package com.practice.springhomework002.repository;

import com.practice.springhomework002.model.entity.Instructor;
import com.practice.springhomework002.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IInstructorRepository {

    @Results(id = "instructorMapper", value = {@Result(property = "instructorId", column = "instructor_id"), @Result(property = "instructorName", column = "instructor_name"),})
    @Select("""
                SELECT  * FROM instructors
                OFFSET #{offset} LIMIT #{size}
            """)
    List<Instructor> getALlInstructors(int offset, int size);

    @ResultMap("instructorMapper")
    @Select("""
            SELECT * FROM instructors
            WHERE instructor_id = #{instructorId}
            """)
    Instructor getInstructorById(int instructorId);

    @ResultMap("instructorMapper")
    @Select("""
                INSERT INTO instructors VALUES (
                    default,
                    #{request.instructorName},
                    #{request.email}
                ) RETURNING *
            """)
    Instructor saveInstructor(@Param("request") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
                UPDATE instructors
                SET 
                instructor_name = #{request.instructorName},
                email = #{request.email}
                WHERE instructor_id = #{instructorId}
                RETURNING *
                
            """)
    Instructor updateInstructorById(@Param("request") InstructorRequest request, int instructorId);

    @Delete("""
        DELETE FROM instructors
        WHERE instructor_id = #{instructorId}
    """)
    void deleteInstructorById(Integer instructorId);
}
