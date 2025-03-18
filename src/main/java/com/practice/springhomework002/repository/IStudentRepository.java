package com.practice.springhomework002.repository;

import com.practice.springhomework002.model.entity.Student;
import com.practice.springhomework002.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IStudentRepository {

    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "com.practice.springhomework002.repository.IStudentCourseRepository.getCourseByStudentId"))
    })
    @Select("""
                SELECT * FROM students ORDER BY student_id OFFSET #{offset} LIMIT #{limit};
            """)
    List<Student> getAllStudents(int offset, int limit);

    @ResultMap("studentMapper")
    @Select("""
            SELECT * FROM students
            WHERE student_id = #{studentId}
            """)
    Student getStudentById(Integer studentId);

    @ResultMap("studentMapper")
    @Select("""
                INSERT INTO students VALUES (
                    default,
                    #{request.studentName},
                    #{request.email},
                    #{request.phoneNumber}
                ) RETURNING *
            """)
    Student saveStudent(@Param("request") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
                UPDATE students
                SET 
                student_name = #{request.studentName},
                email = #{request.email},
                phone_number = #{request.phoneNumber}
                WHERE student_id = #{studentId}
                RETURNING *
                
            """)
    Student updateStudentById(@Param("request") StudentRequest request, Integer studentId);

    @Delete("""
        DELETE FROM students
        WHERE student_id = #{studentId}
    """)
    void deleteStudentById(Integer studentId);
}
