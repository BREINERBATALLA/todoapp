package com.breiner.todoapp.application.service;

import com.breiner.todoapp.application.mapper.TaskMapper;
import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.repository.ITaskRepository;
import com.breiner.todoapp.domain.usecase.ITaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ITaskService implements ITaskUseCase {

    private final ITaskRepository iTaskRepository;
    private final TaskMapper taskMapper;
    @Override
    public List<TaskResponseDto> findAllTasks() {
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
