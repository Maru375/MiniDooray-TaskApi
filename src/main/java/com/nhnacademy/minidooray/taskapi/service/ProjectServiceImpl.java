package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectUpdateRequest;
import com.nhnacademy.minidooray.taskapi.enums.AuthType;
import com.nhnacademy.minidooray.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.minidooray.taskapi.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMemberRepository memberRepository;

    @Override
    public List<ProjectNameResponse> getProjects(String id) {
        List<ProjectNameResponse> projects = projectRepository.findByProjectMembers_Pk_MemberId(id);

        if (projects.isEmpty()) {
            return Collections.emptyList();
        }
        return projects;
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
    public ProjectResponse createProject(String userId, ProjectCreateRequest projectCreateRequest) {
        Project project = projectRepository.save(projectCreateRequest.toEntity());
        ProjectMember.Pk memberPk = new ProjectMember.Pk(userId, project.getProjectId());
        memberRepository.save(new ProjectMember(memberPk, project, AuthType.ADMIN));
        return new ProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Integer id, ProjectUpdateRequest projectUpdateRequest) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id : " + id + "는 찾을 수 없는 프로젝트 입니다."));

        if(project != null){
            if(projectUpdateRequest.getProjectName() != null){
                project.setProjectName(projectUpdateRequest.getProjectName());
            }
            if(projectUpdateRequest.getProjectContent() != null){
                project.setProjectContent(projectUpdateRequest.getProjectContent());
            }
            if(projectUpdateRequest.getTagId() != null){
                project.setTag(projectUpdateRequest.getTagId());
            }
            if(projectUpdateRequest.getMilestoneId() != null){
                project.setMilestone(projectUpdateRequest.getMilestoneId());
            }
            project.setModifiedAt(LocalDateTime.now());
            return new ProjectResponse(projectRepository.save(project));
        }
        return null;
    }

    @Override
    public void deleteProject(Integer id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("id : " + id + "는 찾을 수 없는 아이디 입니다.");
        }
        projectRepository.deleteById(id);
    }
}
