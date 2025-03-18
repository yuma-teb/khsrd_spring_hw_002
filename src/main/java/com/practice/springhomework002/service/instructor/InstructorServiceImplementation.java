package com.practice.springhomework002.service.instructor;

import com.practice.springhomework002.model.entity.Instructor;
import com.practice.springhomework002.model.request.InstructorRequest;
import com.practice.springhomework002.repository.IInstructorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImplementation implements IInstructorService {
    private final IInstructorRepository instructorRepository;

    public InstructorServiceImplementation(IInstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructors(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return instructorRepository.getALlInstructors(offset, size);
    }

    @Override
    public Instructor getInstructorById(Integer instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor saveInstructor(InstructorRequest request) {
        return instructorRepository.saveInstructor(request);
    }

    @Override
    public Instructor updateInstructorById(InstructorRequest request, Integer instructorId) {
        Instructor instructor = instructorRepository.getInstructorById(instructorId);

        if(instructor == null) {
            return null;
        }

        return instructorRepository.updateInstructorById(request, instructorId);
    }

}
