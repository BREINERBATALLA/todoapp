package com.breiner.todoapp.domain.dto.request;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    @NotEmpty(message = "title can't be empty")
    private String title;
    private String description;
}
