package com.breiner.todoapp.application.mapper;

import com.breiner.todoapp.domain.dto.request.UserRegisterRequestDto;
import com.breiner.todoapp.domain.dto.response.UserResponseDto;
import com.breiner.todoapp.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "role", ignore = true),
            @Mapping(target = "id", ignore = true ),
            @Mapping(target = "authorities", ignore = true )


    })
    User toUserFromUserRegisterDto(UserRegisterRequestDto userRegisterDto);

    UserResponseDto toUserResponseDtoFromUser(User user);

    @Mappings({
            @Mapping(target = "password", ignore = true ),
            @Mapping(target = "role", ignore = true ),
            @Mapping(target = "authorities", ignore = true )
    })
    User toUserFromUserResponseDto(UserResponseDto userDto);
}
