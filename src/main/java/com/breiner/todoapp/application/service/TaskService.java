package com.breiner.todoapp.application.service;

import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.entity.Task;
import com.breiner.todoapp.domain.usecase.TaskUseCase;

import java.util.List;

public class TaskService implements TaskUseCase {
    @Override
    public List<Task> findAllTasks() {
        return null;
    }

    @Override
    public Long findTaskById(Long id) {
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {

    }

    @Override
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto) {
        return null;
    }
}
