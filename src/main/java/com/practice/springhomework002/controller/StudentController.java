package com.practice.springhomework002.controller;

import com.practice.springhomework002.dto.ApiResponse;
import com.practice.springhomework002.model.Student;
import com.practice.springhomework002.service.student.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllUsers(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        List<Student> students = studentService.getAllStudents(page, size);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "success", students));
    }
}
