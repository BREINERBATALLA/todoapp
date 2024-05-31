package com.breiner.todoapp.domain.usecase;

import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.entity.Task;

import java.util.List;

public interface ITaskUseCase {

    List<Task> findAllTasks();

    Long findTaskById(Long id);

    void deleteTaskById(Long id);

    TaskResponseDto updateTask(TaskRequestDto taskRequestDto);
}
