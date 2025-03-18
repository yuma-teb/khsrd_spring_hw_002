package com.practice.springhomework002.service.student;

import com.practice.springhomework002.model.entity.Student;
import com.practice.springhomework002.model.request.StudentRequest;
import com.practice.springhomework002.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements IStudentService{
private final IStudentRepository studentRepository;

    public StudentServiceImplementation(
            IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(int page, int size) {
        int offset = (page - 1) * size;
        return studentRepository.getAllStudents(offset, size);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest request) {
        return studentRepository.saveStudent(request);
    }

    @Override
    public Student updateStudentById(StudentRequest request, Integer studentId) {
        return studentRepository.updateStudentById(request, studentId);
    }

    @Override
    public Boolean deleteStudentById(Integer studentId) {
        Student student = studentRepository.getStudentById(studentId);

        if(student == null) {
            return false;
        }

        studentRepository.deleteStudentById(studentId);
        return true;
    }
}
