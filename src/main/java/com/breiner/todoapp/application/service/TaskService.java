package com.breiner.todoapp.application.service;

import com.breiner.todoapp.application.mapper.TaskMapper;
import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.entity.Task;
import com.breiner.todoapp.domain.repository.ITaskRepository;
import com.breiner.todoapp.domain.usecase.ITaskUseCase;
import com.breiner.todoapp.infraestructure.exception.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskUseCase {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskResponseDto> findAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long findTaskById(Long id) {
        return taskRepository.findById(id)
                .map(Task::getId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }

    @Override
    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id " + id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task savedTask = taskRepository.save(taskMapper.toTask(taskRequestDto));
        return taskMapper.toTaskResponseDto(savedTask);
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto) {
        return taskRepository.findById(id)
                .map(task -> {
                        task.setTitle(taskRequestDto.title());
                        task.setDescription(taskRequestDto.description());
                    return taskMapper.toTaskResponseDto(taskRepository.save(task));
                })
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }
}
