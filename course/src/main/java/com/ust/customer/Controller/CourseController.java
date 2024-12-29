package com.ust.customer.Controller;


import com.ust.customer.Model.Course;
import com.ust.customer.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course){

        return service.addCourse(course);
    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = service.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
}
    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody @Valid Course course) {
        return service.updateCourse(id, course);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable int id) {

        service.deleteCourse(id);
    }

}
