package com.practice.springhomework002.repository;


import com.practice.springhomework002.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IStudentRepository {

    @Select("""
        SELECT * FROM students OFFSET #{offet} LIMIT ${limit};
    """)
    List<Student> getAllStudents(int offset, int limit);
}
