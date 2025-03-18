package com.practice.springhomework002.service.student;

import com.practice.springhomework002.model.entity.Student;
import com.practice.springhomework002.model.request.StudentRequest;
import com.practice.springhomework002.repository.IStudentCourseRepository;
import com.practice.springhomework002.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements IStudentService {
    private final IStudentRepository studentRepository;
    private final IStudentCourseRepository studentCourseRepository;

    public StudentServiceImplementation(
            IStudentRepository studentRepository, IStudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
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
        Student student = studentRepository.saveStudent(request);
        for(Integer courseId: request.getCourseId()) {
            studentCourseRepository.saveStudentCourse(student.getStudentId(), courseId);
        }

        return getStudentById(student.getStudentId());
    }

    @Override
    public Student updateStudentById(StudentRequest request, Integer studentId) {
        Student student = studentRepository.updateStudentById(request, studentId);

        studentCourseRepository.deleteStudentCourseByStudentId(studentId);

        for(Integer courseId: request.getCourseId()) {
            studentCourseRepository.saveStudentCourse(studentId, courseId);
        }

        return getStudentById(student.getStudentId());
    }

    @Override
    public Boolean deleteStudentById(Integer studentId) {
        Student student = studentRepository.getStudentById(studentId);

        if (student == null) {
            return false;
        }

        studentRepository.deleteStudentById(studentId);
        return true;
    }
}
