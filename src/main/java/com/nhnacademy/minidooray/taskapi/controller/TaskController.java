package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;
import com.nhnacademy.minidooray.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{projectId}")
    public List<TaskNameResponse> getTasks(@PathVariable Integer projectId){
        return taskService.getTasks(projectId);
    }

    @GetMapping("/{projectId}/{taskId}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Integer projectId, @PathVariable Integer taskId){
        TaskResponse task = taskService.getTask(projectId, taskId);
        if(task != null){
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }
}
