package com.practice.springhomework002.controller;

import com.practice.springhomework002.dto.ApiResponse;
import com.practice.springhomework002.model.entity.Instructor;
import com.practice.springhomework002.model.request.InstructorRequest;
import com.practice.springhomework002.service.instructor.IInstructorService;
import com.practice.springhomework002.service.instructor.InstructorServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final IInstructorService instructorService;

    public InstructorController(InstructorServiceImplementation instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        List<Instructor> instructors = instructorService.getAllInstructors(page, size);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "success", instructors));
    }

    @GetMapping("{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Integer instructorId ) {
        Instructor instructor = instructorService.getInstructorById(instructorId);

        if(instructor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, null, instructor));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> saveInstructor(@RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.saveInstructor(request);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED, null, instructor)) ;
    }

    @PutMapping("{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@RequestBody InstructorRequest request,
                                                                        @PathVariable("instructor-id") Integer instructorId) {
        Instructor instructor = instructorService.updateInstructorById(request, instructorId);

        if(instructor == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(HttpStatus.NOT_FOUND, "Instructor not found", null))
                    ;
        }
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Instructor has been updated!", instructor));
    }

    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable("instructor-id") Integer instructorId) {
        instructorService.deleteInstructorById(instructorId);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Instructor has been deleted", null));
    }
}
