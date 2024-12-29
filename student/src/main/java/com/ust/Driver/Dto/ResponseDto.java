package com.ust.Driver.Dto;


import java.util.List;


public class ResponseDto {

    public List<CourseDto> customerdto;
    public StudentDto driverDto;

    public List<CourseDto> getCustomerdto() {

        return customerdto;
    }

    public void setCustomerdto(List<CourseDto> customerdto) {

        this.customerdto = customerdto;
    }

    public StudentDto getDriverDto() {

        return driverDto;
    }

    public void setDriverDto(StudentDto driverDto) {

        this.driverDto = driverDto;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "customerdto=" + customerdto +
                ", driverDto=" + driverDto +
                '}';
    }

    public ResponseDto() {
    }

    public ResponseDto(List<CourseDto> customerdto, StudentDto driverDto) {
        this.customerdto = customerdto;
        this.driverDto = driverDto;
    }
}
