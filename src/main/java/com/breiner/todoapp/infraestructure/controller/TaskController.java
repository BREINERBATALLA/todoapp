package com.breiner.todoapp.infraestructure.controller;

import com.breiner.todoapp.domain.dto.request.TaskRequestDto;
import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.usecase.ITaskUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/linktic/v1/tasks")
public class TaskController {


    private final ITaskUseCase taskUseCase;

    @Operation(
            description = "Get endpoint for category",
            summary = "Get all categories",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Getting internal server error", responseCode = "500")
            }
    )
    @GetMapping("/categories")
    public ResponseEntity<List<TaskResponseDto>> findAllTask() {
        return ResponseEntity.ok(taskUseCase.findAllTasks());
    }

    @Operation(
            description = "Create a new task",
            summary = "Create task",
            responses = {
                    @ApiResponse(description = "Task created successfully", responseCode = "201"),
                    @ApiResponse(description = "Bad request", responseCode = "400"),
                    @ApiResponse(description = "Internal server error", responseCode = "500")
            }
    )
    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto) {
        TaskResponseDto createdTask = taskUseCase.createTask(taskRequestDto);
        return ResponseEntity.status(201).body(createdTask);
    }

    @Operation(
            description = "Update an existing task",
            summary = "Update task",
            responses = {
                    @ApiResponse(description = "Task updated successfully", responseCode = "200"),
                    @ApiResponse(description = "Task not found", responseCode = "404"),
                    @ApiResponse(description = "Bad request", responseCode = "400"),
                    @ApiResponse(description = "Internal server error", responseCode = "500")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequestDto taskRequestDto) {
        TaskResponseDto updatedTask = taskUseCase.updateTask(id, taskRequestDto);
        return ResponseEntity.ok(updatedTask);
    }

    @Operation(
            description = "Delete an existing task",
            summary = "Delete task",
            responses = {
                    @ApiResponse(description = "Task deleted successfully", responseCode = "200"),
                    @ApiResponse(description = "Task not found", responseCode = "404"),
                    @ApiResponse(description = "Internal server error", responseCode = "500")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskUseCase.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }
}
