package com.ust.Driver.Service;

import com.ust.Driver.Dto.CourseDto;
import com.ust.Driver.Dto.StudentDto;
import com.ust.Driver.Dto.ResponseDto;
import com.ust.Driver.Model.Student;
import com.ust.Driver.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    @Autowired
    private WebClient webclient;

    public Student addStudent(Student student){
        return repo.save(student);
    }

    @CircuitBreaker(name = "driverService", fallbackMethod = "fallbackGetBooking")
    public ResponseDto getCourse(String courseName) {
        ResponseDto responseDto = new ResponseDto();
        List<Student> driver = repo.findByCourseName(courseName);//(() -> new RuntimeException("Vehicle not found"));
        StudentDto driverDto = mapToDriverDto((Student) driver);

        List<CourseDto> customerdtolist = webclient.get()
                .uri("http://localhost:9097/customer/" + ((Student) driver).getCourseName())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CourseDto>>() {
                })
                .block();

        responseDto.setDriverDto(driverDto);
        responseDto.setCustomerdto(customerdtolist);

        return responseDto;
    }
    public ResponseDto fallbackGetBooking(String VehcileNumber, Throwable throwable) {
        // Handle the fallback logic, e.g., return a default response or log the error
        return new ResponseDto(); // Return an empty response or a default response
    }


    private StudentDto mapToDriverDto(Student driver) {
        StudentDto driverdto = new StudentDto();
        driverdto.setStudentId(driver.getStudentId());
        driverdto.setName(driver.getName());
        //driverdto.setVehicleType(driver.getCourseName());
//        driverdto.setLicenseNumber(driver.getEmail());
//        driverdto.setVehcileNumber(driver.getCourseName());

        return driverdto;
    }

    public List<Student> getStudentsByCourseName(String courseName) {

        return repo.findByCourseName(courseName);
    }
    public Student updateStudent(int id, Student student) {
        Optional<Student> existingStudent = repo.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setEmail(student.getEmail());
           // updatedStudent.setCourseId(student.getCourseId());
            return repo.save(updatedStudent);
        }
        return null;
    }
    public boolean deleteStudent(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
