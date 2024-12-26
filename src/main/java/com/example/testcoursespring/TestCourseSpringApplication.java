package com.example.testcoursespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TestCourseSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCourseSpringApplication.class, args);
    }

}
