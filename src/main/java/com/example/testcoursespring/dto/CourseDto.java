package com.example.testcoursespring.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    int idCourse;
    String title;
    int price;
    String image;


    public CourseDto(CourseDto courseDto) {
        this.idCourse = courseDto.getIdCourse();
        this.title = courseDto.getTitle();
        this.price = courseDto.getPrice();
        this.image = courseDto.getImage();
    }

}