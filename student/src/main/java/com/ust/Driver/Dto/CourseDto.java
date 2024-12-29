package com.ust.Driver.Dto;

public class CourseDto {

    public int courseId;
    public String courseName;
    public String courseDescription;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public CourseDto() {
    }

    public CourseDto(int courseId, String courseDescription, String courseName) {
        this.courseId = courseId;
        this.courseDescription = courseDescription;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
