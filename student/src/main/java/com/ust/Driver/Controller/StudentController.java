package com.ust.Driver.Controller;

import com.ust.Driver.Dto.ResponseDto;
import com.ust.Driver.Model.Student;
import com.ust.Driver.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){

        return service.addStudent(student);
    }



    @GetMapping("withStudent/{courseName}")
    public ResponseEntity<ResponseDto> getStudentByCourseName(@PathVariable("courseName") String courseName){
        ResponseDto responseDto = service.getCourse(courseName);
        return ResponseEntity.ok(responseDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody @Valid Student student) {
        Student updatedStudent = service.updateStudent(id, student);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        boolean deleted = service.deleteStudent(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found
    }
}
