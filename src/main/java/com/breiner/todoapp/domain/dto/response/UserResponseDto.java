package com.breiner.todoapp.domain.dto.response;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
        private Long id;

        @Email(message = "El formato de email no es válido")
        private String email;

        private String firstName;
        private String lastName;
}

