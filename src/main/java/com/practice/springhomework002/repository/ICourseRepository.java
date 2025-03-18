package com.practice.springhomework002.repository;

import com.practice.springhomework002.model.entity.Course;
import com.practice.springhomework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ICourseRepository {

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
