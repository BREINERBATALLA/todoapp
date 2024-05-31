package com.breiner.todoapp.infraestructure.controller;

import com.breiner.todoapp.domain.dto.response.TaskResponseDto;
import com.breiner.todoapp.domain.usecase.ITaskUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("linktic/v1")
public class TaskController {

    private final ITaskUseCase taskUseCase;

    @Operation(
            description = "Get endpoint for category",
            summary = "Get all categories",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Getting internal server error",
                            responseCode = "500"
                    )
            }

    )
    @GetMapping("/categories")
    public ResponseEntity<List<TaskResponseDto>> findAllTask(){
        return ResponseEntity.ok(taskUseCase.findAllTasks());
    }
}
