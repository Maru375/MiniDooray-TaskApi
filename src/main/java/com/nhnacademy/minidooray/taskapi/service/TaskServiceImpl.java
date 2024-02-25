package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Task;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskResponse;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskUpdateRequest;
import com.nhnacademy.minidooray.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskNameResponse> getTasks(Integer id) {
        return taskRepository.findAllByProject_ProjectId(id);
    }

    @Override
    public TaskResponse getTask(Integer projectId, Integer taskId) {

        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null && task.getProject() != null && task.getProject().getProjectId().equals(projectId)) {
            return new TaskResponse(task);
        }
        return null;
    }

    @Override
    public TaskResponse createTask(TaskCreateRequest taskCreateRequest) {
        return new TaskResponse(taskRepository.save(taskCreateRequest.toEntity()));
    }

    @Override
    public TaskResponse updateTask(Integer id, TaskUpdateRequest updateRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id : " + id + "는 찾을 수 없는 테스크 입니다."));

        if(task != null){
            if(updateRequest.getTaskName() != null){
                task.setTaskName(updateRequest.getTaskName());
            }
            if(updateRequest.getTaskContent() != null){
                task.setTaskContent(updateRequest.getTaskContent());
            }
            if(updateRequest.getTag() != null){
                task.setTag(updateRequest.getTag());
            }
            if(updateRequest.getMilestone() != null){
                task.setMilestone(updateRequest.getMilestone());
            }
            if(updateRequest.getTaskState() != null){
                task.setTaskState(updateRequest.getTaskState());
            }
            task.setModifiedAt(LocalDateTime.now());
            return new TaskResponse(taskRepository.save(task));
        }
        return null;
    }

    @Override
    public void deleteTask(Integer id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("id : " + id + "는 찾을 수 없는 아이디 입니다.");
        }
        taskRepository.deleteById(id);
    }
}
