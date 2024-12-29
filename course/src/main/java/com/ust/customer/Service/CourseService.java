package com.ust.customer.Service;

import com.ust.customer.Model.Course;
import com.ust.customer.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo repo;

    public Course addCourse(Course course){
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }
    public Course updateCourse(int id, Course course) {
        course.setCourseId(id);
        return repo.save(course);
    }
    public boolean deleteCourse(int id) {
        repo.deleteById(id);
        return true;
    }

}
