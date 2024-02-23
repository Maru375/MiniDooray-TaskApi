package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.project.*;

import java.util.List;

public interface ProjectService {
    List<ProjectSimpleResponse> getProjects();

    ProjectResponse getProject(Integer id);

    ProjectResponse createProject(ProjectCreateRequest projectCreateRequest);

    ProjectResponse updateProject(ProjectUpdateRequest projectUpdateRequest);

    void deleteProject(Integer id);
}
