package com.breiner.todoapp.domain.usecase;

import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;

import java.util.List;

public interface ITaskUseCase {

    List<TaskResponseDto> findAllTasks();

    Long findTaskById(Long id);

    void deleteTaskById(Long id);

    TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto);

    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
}
