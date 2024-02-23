package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectSimpleResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectUpdateRequest;
import com.nhnacademy.minidooray.taskapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectSimpleResponse> getProjects() {
        List<Project> projects = projectRepository.findAll();

        if (projects.isEmpty()) {
            return Collections.emptyList();
        }
        return projects.stream()
                .map(ProjectSimpleResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getProject(Integer id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            return null;
        }
        return new ProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectCreateRequest projectCreateRequest) {
        return new ProjectResponse(projectRepository.save(projectCreateRequest.toEntity()));
    }

    @Override
    public ProjectResponse updateProject(ProjectUpdateRequest projectUpdateRequest) {
        return new ProjectResponse(projectRepository.save(projectUpdateRequest.toEntity()));
    }

    @Override
    public void deleteProject(Integer id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("id : " + id + "는 찾을 수 없는 아이디 입니다.");
        }
        projectRepository.deleteById(id);
    }
}
