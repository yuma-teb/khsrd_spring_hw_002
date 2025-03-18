package com.practice.springhomework002.service.course;

import com.practice.springhomework002.model.entity.Course;
import com.practice.springhomework002.model.request.CourseRequest;

import java.util.List;

public interface ICourseService {

    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Integer courseId);

    Course saveCourse(CourseRequest request);

    Course updateCourseById(CourseRequest request, Integer courseId);

    Boolean deleteCourseById(Integer courseId);
}
