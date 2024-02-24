package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.task.TaskCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;
import com.nhnacademy.minidooray.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskNameResponse> getTasks(Integer id) {
        return taskRepository.findAllByProject_ProjectId(id);
    }

    @Override
    public TaskResponse getTask(Integer id) {
        return null;
    }

    @Override
    public TaskResponse createTask(TaskCreateRequest taskCreateRequest) {
        return null;
    }

    @Override
    public TaskResponse updateTask(Integer id, TaskCreateRequest createRequest) {
        return null;
    }

    @Override
    public void deleteTask(Integer id) {

    }
}
