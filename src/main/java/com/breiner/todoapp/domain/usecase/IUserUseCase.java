package com.breiner.todoapp.domain.usecase;

import com.breiner.todoapp.domain.dto.request.UserRegisterRequestDto;
import com.breiner.todoapp.domain.dto.response.UserResponseDto;
import com.breiner.todoapp.domain.entity.User;
import java.util.Optional;

public interface IUserUseCase {

    UserResponseDto getCurrentLoggedUser();

    UserResponseDto saveUser(UserRegisterRequestDto user, String password);

    Optional<User> findByEmail(String email);

}
