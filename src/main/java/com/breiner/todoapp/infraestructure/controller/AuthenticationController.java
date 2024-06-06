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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/linktic/v1/auth")
public class AuthenticationController {

    private final IAuthenticationUseCase authenticationUseCase;

    @PostMapping(path = "/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody @Valid UserRegisterRequestDto userRegisterDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authenticationUseCase.userRegister(userRegisterDTO));
    }


    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(
            @RequestBody @Valid UserRequestAuthDto authUserDto
    ) {
        return ResponseEntity.ok(authenticationUseCase.singIn(authUserDto));
    }
}
