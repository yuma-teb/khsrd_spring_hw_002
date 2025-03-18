package com.practice.springhomework002.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private HttpStatus status;
    private String message;
    private T payload;

    private LocalDate date = LocalDate.now();

    public ApiResponse(HttpStatus status, String message, T payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }

}
