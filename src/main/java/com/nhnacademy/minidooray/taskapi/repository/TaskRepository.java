package com.nhnacademy.minidooray.taskapi.repository;

import com.nhnacademy.minidooray.taskapi.domain.Task;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskNameResponse> findAllByProject_ProjectId(Integer id);
}
