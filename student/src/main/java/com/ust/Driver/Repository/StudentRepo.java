package com.ust.Driver.Repository;

import com.ust.Driver.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findByCourseName(String courseName);

    //List<Driver> findByBookingNumber(int bookingNumber);
}
