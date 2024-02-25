package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.project.ProjectCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectUpdateRequest;

import java.util.List;

public interface ProjectService {
    List<ProjectNameResponse> getProjects(String id);

    ProjectResponse getProject(Integer id);

    ProjectResponse createProject(String userId, ProjectCreateRequest projectCreateRequest);

    ProjectResponse updateProject(Integer id, ProjectUpdateRequest projectUpdateRequest);

    void deleteProject(Integer id);
}
