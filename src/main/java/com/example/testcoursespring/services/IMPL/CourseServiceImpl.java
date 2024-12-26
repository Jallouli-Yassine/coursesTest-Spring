package com.example.testcoursespring.services.IMPL;

import com.example.testcoursespring.models.Course;
import com.example.testcoursespring.repository.ICourseRepo;
import com.example.testcoursespring.services.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService {
    ICourseRepo courseRepo;


    @Override
    public Course addCourse(Course c) {
        return courseRepo.save(c);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int idCourse) {
        return courseRepo.findById(idCourse).orElse(null);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(int idCourse) {
        courseRepo.deleteById(idCourse);
    }
}
