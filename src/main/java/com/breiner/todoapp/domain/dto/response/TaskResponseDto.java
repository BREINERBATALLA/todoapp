package com.breiner.todoapp.domain.dto.response;

import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
}

