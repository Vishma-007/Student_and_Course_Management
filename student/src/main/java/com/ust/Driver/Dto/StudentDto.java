package com.ust.Driver.Dto;


public class StudentDto {

    public int studentId;
    public String Name;
    public String email;
    public String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public StudentDto() {
    }

    public StudentDto(int studentId, String courseName, String name, String email) {
        this.studentId = studentId;
        this.courseName = courseName;
        Name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "studentId=" + studentId +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
