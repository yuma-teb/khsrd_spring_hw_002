package com.practice.springhomework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
}
