package com.breiner.todoapp.infraestructure.controller;


import com.breiner.todoapp.domain.dto.request.UserRegisterRequestDto;
import com.breiner.todoapp.domain.dto.request.UserRequestAuthDto;
import com.breiner.todoapp.domain.dto.response.JwtResponseDto;
import com.breiner.todoapp.domain.dto.response.UserRegisterResponseDto;
import com.breiner.todoapp.domain.usecase.IAuthenticationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/linktic/v1/auth")
@CrossOrigin
public class AuthenticationController {

    private final IAuthenticationUseCase authenticationUseCase;

    @Operation(
            summary = "Register a new user",
            description = "Registers a new user and returns the user details",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping(path = "/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody @Valid UserRegisterRequestDto userRegisterDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authenticationUseCase.userRegister(userRegisterDTO));
    }

    @Operation(
            summary = "Sign in an existing user",
            description = "Authenticates a user and returns a JWT token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User authenticated successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid credentials")
            }
    )
    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(
            @RequestBody @Valid UserRequestAuthDto authUserDto
    ) {
        return ResponseEntity.ok(authenticationUseCase.singIn(authUserDto));
    }
}

