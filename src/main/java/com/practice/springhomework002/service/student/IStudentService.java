package com.practice.springhomework002.service.student;

import com.practice.springhomework002.model.entity.Student;
import com.practice.springhomework002.model.request.StudentRequest;

import java.util.Iterator;
import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents(int page, int size);

    Student getStudentById(Integer studentId);

    Student saveStudent(StudentRequest request);

    Student updateStudentById(StudentRequest request, Integer studentId);

    Boolean deleteStudentById(Integer studentId);
}
