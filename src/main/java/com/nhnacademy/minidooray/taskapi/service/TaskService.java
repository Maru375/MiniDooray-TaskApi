package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.task.TaskCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskUpdateRequest;

import java.util.List;

public interface TaskService {

    List<TaskNameResponse> getTasks(Integer id);

    TaskResponse getTask(Integer projectId, Integer taskId);

    TaskResponse createTask(TaskCreateRequest taskCreateRequest);

    TaskResponse updateTask(Integer id, TaskUpdateRequest taskUpdateRequest);

    void deleteTask(Integer id);
}
