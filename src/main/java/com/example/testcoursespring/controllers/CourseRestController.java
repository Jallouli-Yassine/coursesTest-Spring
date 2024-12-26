package com.example.testcoursespring.controllers;

import com.example.testcoursespring._services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("course")
@RestController
public class CourseRestController {
    ICourseService courseService;
}
