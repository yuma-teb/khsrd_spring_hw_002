package com.practice.springhomework002.repository;

import com.practice.springhomework002.model.entity.Course;
import org.apache.ibatis.annotations.*;

import javax.naming.InterruptedNamingException;
import java.util.List;

@Mapper
public interface IStudentCourseRepository {

    @Result(property = "courseId", column = "course_id")
    @Result(property = "courseName", column = "course_name")
    @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.practice.springhomework002.repository.IInstructorRepository.getInstructorById"))

    @Select("""
                SELECT * FROM student_course sc
                INNER JOIN courses c
                ON sc.course_id = c.course_id
                WHERE sc.student_id = #{studentId}
            """)
    List<Course> getCourseByStudentId(Integer studentId);

    @Insert("""
                INSERT INTO student_course
                VALUES (
                        #{studentId},
                        #{courseId}
                )
            """)
    void saveStudentCourse(Integer studentId, Integer courseId);

    @Delete("""
                DELETE FROM student_course
                WHERE student_id = #{studentId}
            """)
    void deleteStudentCourseByStudentId(Integer studentId);
}
