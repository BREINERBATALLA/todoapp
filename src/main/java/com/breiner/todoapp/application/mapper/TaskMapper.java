package com.breiner.todoapp.application.mapper;

import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toTask(TaskRequestDto taskRequestDto);

    TaskResponseDto toTaskResponseDto(Task task);

}
