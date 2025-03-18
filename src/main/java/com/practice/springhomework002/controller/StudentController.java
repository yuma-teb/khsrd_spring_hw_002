package com.practice.springhomework002.controller;

import com.practice.springhomework002.dto.ApiResponse;
import com.practice.springhomework002.model.entity.Student;
import com.practice.springhomework002.model.request.StudentRequest;
import com.practice.springhomework002.service.student.IStudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
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

    @GetMapping("{student-id}")
    public ResponseEntity<ApiResponse<?>> getStudentById(@PathVariable("student-id") Integer studentId) {
        Student student = studentService.getStudentById(studentId);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>().builder().status(HttpStatus.NOT_FOUND).message("Student with the id not found").payload(null).build());
        }

        return ResponseEntity.ok(new ApiResponse<>().builder().status(HttpStatus.OK).message("success").payload(student).build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> saveStudent(StudentRequest request) {
        Student student = studentService.saveStudent(request);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "created success", student));
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<?>> updateStudentById(@RequestBody StudentRequest request, @PathVariable("student-id") Integer studentId) {
        Student student = studentService.updateStudentById(request, studentId);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>().builder().status(HttpStatus.NOT_FOUND).message("Student with the id not found").payload(null).build());
        }

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Update successfully", student));
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<?>> deleteStudentById(@PathVariable("student-id") Integer studentId) {
        Boolean isDeleted = studentService.deleteStudentById(studentId);

        return isDeleted ? ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "delete successfully", null)) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>().builder().status(HttpStatus.NOT_FOUND).message("student with the id is not found").payload(null).build());

    }
}
