package com.practice.springhomework002.controller;

import com.practice.springhomework002.dto.ApiResponse;
import com.practice.springhomework002.model.entity.Course;
import com.practice.springhomework002.model.request.CourseRequest;
import com.practice.springhomework002.service.course.CourseServiceImplementation;
import com.practice.springhomework002.service.course.ICourseService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final ICourseService courseService;

    public CourseController(CourseServiceImplementation courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size

            ) {
        List<Course> courses = courseService.getAllCourses(page, size);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "success", courses));
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(Integer courseId) {
        Course course = courseService.getCourseById(courseId);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "success", course));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> saveCourse(CourseRequest request) {
        Course course = courseService.saveCourse(request);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "created successfully", course));
    }

    @PutMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable("course-id") Integer courseId, @RequestBody CourseRequest request) {
        Course course = courseService.updateCourseById(request, courseId);

        if(course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(HttpStatus.NOT_FOUND, "Course is not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "updated successfully", null));
    }

    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable("course-id") Integer courseId) {
        Boolean isDeleted = courseService.deleteCourseById(courseId);

        if(!isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(HttpStatus.NOT_FOUND, "Course with id is not found", null));
        }

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Deleted successfully", null));
    }
}
