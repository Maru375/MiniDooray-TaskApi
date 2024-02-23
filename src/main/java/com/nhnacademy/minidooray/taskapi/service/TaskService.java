package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Task;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getTasks();

    TaskResponse getTask(Integer id);

    TaskResponse createTask(Task task);

    TaskResponse updateTask(Task task);

    void deleteTask(Integer id);
}
