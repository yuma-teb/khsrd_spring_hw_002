package com.practice.springhomework002.model.request;

import com.practice.springhomework002.model.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Instructor instructor;
}
