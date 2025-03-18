package com.practice.springhomework002.service.instructor;

import com.practice.springhomework002.model.entity.Instructor;
import com.practice.springhomework002.model.request.InstructorRequest;

import java.util.List;

public interface IInstructorService {
    List<Instructor> getAllInstructors(Integer page, Integer size);

    Instructor getInstructorById(Integer instructorId);

    Instructor saveInstructor(InstructorRequest request);

    Instructor updateInstructorById(InstructorRequest request, Integer instructorId);
}
