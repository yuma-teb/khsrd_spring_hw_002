package com.practice.springhomework002.service.course;

import com.practice.springhomework002.model.entity.Course;
import com.practice.springhomework002.model.request.CourseRequest;
import com.practice.springhomework002.repository.ICourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplementation implements ICourseService {
    private final ICourseRepository courseRepository;

    public CourseServiceImplementation(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        return courseRepository.getAllCourses(offset, size);
    }

    public Course getCourseById(Integer courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course saveCourse(CourseRequest request) {
        return courseRepository.saveCourse(request);
    }

    @Override
    public Course updateCourseById(CourseRequest request, Integer courseId) {
        Course course = courseRepository.getCourseById(courseId);

        if(course == null) {
            return null;
        }

        return courseRepository.updateCourseById(request, courseId);
    }

    @Override
    public Boolean deleteCourseById(Integer courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if(course == null) {
            return false;
        }

        courseRepository.deleteCourseById(courseId);
        return true;
    }
}
