package com.example.testcoursespring.controllers;

import com.example.testcoursespring.models.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.testcoursespring.services.ICourseService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("course")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseRestController {
    private final ICourseService courseService;

    @GetMapping("/images/{filename}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + filename);
        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        }
        byte[] image = Files.readAllBytes(path);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)  // or IMAGE_PNG depending on your file type
                .body(image);
    }


    private final String UPLOAD_DIR = "uploads/";

    // Add a new course
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(
            @RequestParam("title") String title,
            @RequestParam("price") int price,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        // Save the uploaded image
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, image.getBytes());

        // Create the Course object and set its properties
        Course course = new Course();
        course.setTitle(title);
        course.setPrice(price);
        course.setImage(fileName);

        // Save the course to the database
        return courseService.addCourse(course);
    }



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
