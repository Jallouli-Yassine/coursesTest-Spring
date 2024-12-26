package com.example.testcoursespring.repository;

import com.example.testcoursespring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends JpaRepository<Course,Integer> {
}
