package com.practice.springhomework002.repository;


import com.practice.springhomework002.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IStudentRepository {

    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    @Select("""
                SELECT * FROM students OFFSET #{offset} LIMIT #{limit};
            """)
    List<Student> getAllStudents(int offset, int limit);
}
