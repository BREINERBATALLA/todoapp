package com.breiner.todoapp.application.service;

import com.breiner.todoapp.domain.dto.request.UserRegisterRequestDto;
import com.breiner.todoapp.domain.dto.request.UserRequestAuthDto;
import com.breiner.todoapp.domain.dto.response.JwtResponseDto;
import com.breiner.todoapp.domain.dto.response.UserRegisterResponseDto;
import com.breiner.todoapp.domain.entity.User;
import com.breiner.todoapp.domain.usecase.IAuthenticationUseCase;
import com.breiner.todoapp.domain.usecase.IUserUseCase;
import com.breiner.todoapp.infraestructure.config.security.JwtService;
import com.breiner.todoapp.infraestructure.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationUseCase {

    private final IUserUseCase userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserRegisterResponseDto userRegister(UserRegisterRequestDto user) {
        String passwordGenerated = generateRandomPassword(10);
        userService.saveUser(user, passwordEncoder.encode(passwordGenerated));
        return new UserRegisterResponseDto(passwordGenerated);
    }

    @Override
    public JwtResponseDto singIn(UserRequestAuthDto authUserDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authUserDto.getEmail(), authUserDto.getPassword()
                )
        );
        User user = userService.findByEmail(authUserDto.getEmail())
                .orElseThrow( ()-> new UserNotFoundException("User with email: "+authUserDto.getEmail()+ "not found"));
        String jwtToken = jwtService.generateToken(user);
        return new JwtResponseDto(jwtToken);
    }

    @Override
    public String generateRandomPassword(int length) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
