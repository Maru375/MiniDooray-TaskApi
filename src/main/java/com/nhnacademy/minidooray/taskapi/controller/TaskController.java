package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.dto.task.TaskCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskUpdateRequest;
import com.nhnacademy.minidooray.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/{projectId}/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskNameResponse> getTasks(@PathVariable Integer projectId){
        return taskService.getTasks(projectId);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Integer projectId, @PathVariable Integer taskId){
        TaskResponse task = taskService.getTask(projectId, taskId);
        if(task != null){
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskCreateRequest taskCreateRequest, @PathVariable Integer projectId){
        TaskResponse task = taskService.createTask(projectId, taskCreateRequest);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Integer taskId, @RequestBody TaskUpdateRequest taskUpdateRequest){
        TaskResponse taskResponse = taskService.updateTask(taskId, taskUpdateRequest);
        if (taskResponse != null) {
            return ResponseEntity.ok(taskResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{taskId}")
    public ResultResponse deleteTask(@PathVariable Integer taskId, @PathVariable String projectId) {
        taskService.deleteTask(taskId);
        return new ResultResponse("DELETE OK");
    }
}
