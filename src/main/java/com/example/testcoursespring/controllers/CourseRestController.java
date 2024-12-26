package com.example.testcoursespring.controllers;

import com.example.testcoursespring.models.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.testcoursespring.services.ICourseService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("course")
@RestController
public class CourseRestController {
    private final ICourseService courseService;

    // Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Get course by ID
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    // Add a new course
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    // Update an existing course
    @PutMapping("update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    // Delete a course
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }


}
