package com.breiner.todoapp.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record UserRequestAuthDto(
        @Email(message = "El formato del correo electrónico no es válido")String email,
        @NotBlank(message = "La contraseña no puede estar en blanco") String password) {
}
