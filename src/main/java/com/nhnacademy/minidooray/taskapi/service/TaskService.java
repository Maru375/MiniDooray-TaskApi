package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.task.TaskCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskNameResponse> getTasks(Integer id);

    TaskResponse getTask(Integer id);

    TaskResponse createTask(TaskCreateRequest taskCreateRequest);

    TaskResponse updateTask(Integer id, TaskCreateRequest createRequest);

    void deleteTask(Integer id);
}
