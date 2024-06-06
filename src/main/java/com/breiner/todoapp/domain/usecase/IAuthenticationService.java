package com.breiner.todoapp.domain.usecase;

import com.breiner.todoapp.domain.dto.request.UserRegisterRequestDto;
import com.breiner.todoapp.domain.dto.request.UserRequestAuthDto;
import com.breiner.todoapp.domain.dto.response.JwtResponseDto;
import com.breiner.todoapp.domain.dto.response.UserRegisterResponseDto;

public interface IAuthenticationService {

    UserRegisterResponseDto userRegister (UserRegisterRequestDto user);

    JwtResponseDto singIn (UserRequestAuthDto authUserDto);

    String generateRandomPassword (int length);
}
