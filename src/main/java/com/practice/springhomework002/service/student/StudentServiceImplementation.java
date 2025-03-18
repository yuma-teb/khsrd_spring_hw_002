package com.practice.springhomework002.service.student;

import com.practice.springhomework002.model.Student;
import com.practice.springhomework002.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements IStudentService{
private final IStudentRepository studentRepository;

    public StudentServiceImplementation(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(int page, int size) {
        int offset = (page - 1) * size;
        return studentRepository.getAllStudents(offset, size);
    }
}
