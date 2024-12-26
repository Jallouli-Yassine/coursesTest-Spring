package com.example.testcoursespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.testcoursespring.models.Course;

public interface ICourseRepo extends JpaRepository<Course,Integer> {
}
