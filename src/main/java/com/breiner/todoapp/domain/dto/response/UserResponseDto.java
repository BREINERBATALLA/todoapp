package com.breiner.todoapp.domain.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserResponseDto(

        Long id,
        @Email(message = "El formato de email no es válido")
        String email,

        String firstName,

        String lastName) {}
