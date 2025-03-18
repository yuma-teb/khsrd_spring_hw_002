package com.practice.springhomework002.service.student;

import com.practice.springhomework002.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents(int page, int size);
}
