package com.practice.springhomework002.repository;

import com.practice.springhomework002.model.entity.Course;
import com.practice.springhomework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ICourseRepository {
    @Results(id = "courseMapper", value = {@Result(property = "courseId", column = "course_id"), @Result(property = "courseName", column = "course_name"), @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.practice.springhomework002.repository.IInstructorRepository.getInstructorById"))})
    @Select("""
            SELECT * FROM courses ORDER BY course_id OFFSET #{offset} LIMIT #{limit} 
            """)
    List<Course> getAllCourses(Integer offset, Integer limit);

    @ResultMap("courseMapper")
    @Select("""
                SELECT * FROM courses
                WHERE course_id = #{courseId}
            """)
    Course getCourseById(Integer courseId);

    @ResultMap("courseMapper")
    @Select("""
                INSERT INTO courses
                VALUES (
                default,
                #{request.courseName},
                #{request.description},
                #{request.instructorId}
                )
                RETURNING *
            """)
    Course saveCourse(@Param("request") CourseRequest request);

    @ResultMap("courseMapper")
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
