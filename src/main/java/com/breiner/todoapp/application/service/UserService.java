package com.breiner.todoapp.application.service;

import com.breiner.todoapp.application.mapper.UserMapper;
import com.breiner.todoapp.domain.dto.request.UserRegisterRequestDto;
import com.breiner.todoapp.domain.dto.response.UserResponseDto;
import com.breiner.todoapp.domain.entity.User;
import com.breiner.todoapp.domain.enumeration.Role;
import com.breiner.todoapp.domain.repository.UserRepository;
import com.breiner.todoapp.domain.usecase.IUserUseCase;
import com.breiner.todoapp.infraestructure.exception.UserAlreadyExistsException;
import com.breiner.todoapp.infraestructure.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto getCurrentLoggedUser() {
        User loggedUser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()-> new UserNotFoundException("User not found"));

        return userMapper.toUserResponseDtoFromUser(loggedUser);
    }

    @Override
    public UserResponseDto saveUser(UserRegisterRequestDto userDto, String password) {
        String email = userDto.email();
        if (findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("User with"+ email + "already exists");
        }
        User user = userMapper.toUserFromUserRegisterDto(userDto);
        user.setRole(Role.USER);
        user.setPassword(password);
        return userMapper.toUserResponseDtoFromUser(userRepository.save(user));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
