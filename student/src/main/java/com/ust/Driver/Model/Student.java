package com.ust.Driver.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student {

    @Id
    public int studentId;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    public String Name;

    @Column(unique = true)
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    public String email;
    public String courseName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student() {
    }

    public Student(int studentId, String courseName, String email, String name) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.email = email;
        Name = name;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "studentId=" + studentId +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
