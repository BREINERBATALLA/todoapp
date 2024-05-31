package com.breiner.todoapp.domain.dto.request;
import jakarta.validation.constraints.NotEmpty;
public record TaskRequestDto(
        @NotEmpty(message = "title can't be empty") String title,
        String description
) {
}
