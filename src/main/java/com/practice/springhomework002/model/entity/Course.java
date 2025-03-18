package com.practice.springhomework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
