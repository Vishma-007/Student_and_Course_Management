package com.ust.customer.Repository;

import com.ust.customer.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    List<Course> findByCourseName(String courseName);
}
