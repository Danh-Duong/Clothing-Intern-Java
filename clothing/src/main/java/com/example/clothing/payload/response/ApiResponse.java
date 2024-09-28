package com.example.clothing.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    public static final int DEFAULT_SUCCESS_CODE = 1000;

    int code;
    private LocalDateTime timestamp;
    T data;

    public static <T> ApiResponse<T> response(int code, T data) {
        return ApiResponse.<T>builder()
                .code(code)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
