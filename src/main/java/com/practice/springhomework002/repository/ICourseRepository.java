package com.practice.springhomework002.repository;

import com.practice.springhomework002.model.entity.Course;
import com.practice.springhomework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ICourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.practice.springhomework002.repository.IInstructorRepository.getInstructorById"))
    })
    @Select("""
            SELECT * FROM courses OFFSET #{offset} LIMIT #{limit}
            """)
    List<Course> getAllCourses(Integer offset, Integer limit);

    @Select("""
                SELECT * FROM courses
                WHERE coruse_id = #{courseId}
            """)
    Course getCourseById(Integer courseId);

    @Select("""
                INSERT INTO courses
                VALUES(
                deafult,
                #{request.courseName},
                #{request.description},
                #{request.instructionId}
                )
                RETURNING *
            """)
    Course saveCourse(@Param("request") CourseRequest request);

    @Select("""
                UPDATE courses 
                SET
                #{request.courseName},
                #{request.description},
                #{request.instructionId}
            
                WHERE course_id = #{courseId}
            """)
    Course updateCourseById(@Param("request") CourseRequest request, Integer courseId);

    @Delete("""
        DELETE FROM courses
        WHERE course_id = #{courseId}
    """)
    void deleteCourseById(Integer courseId);
}
