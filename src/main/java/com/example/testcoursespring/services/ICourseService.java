package com.example.testcoursespring.services;

import com.example.testcoursespring.models.Course;
import com.example.testcoursespring.repository.ICourseRepo;

import java.util.List;

public interface ICourseService {

    Course addCourse(Course c);

    List<Course> getAllCourses();

    Course getCourseById(int idCourse);

    Course updateCourse(Course course);

    void deleteCourse(int idCourse);

}
