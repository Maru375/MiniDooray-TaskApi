package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<ProjectMember> getProjectMembers();

    ProjectMember getProjectMember(Integer id);

    ProjectMember createProjectMember(ProjectMember projectMember);

    ProjectMember updateProjectMember(ProjectMember projectMember);

    void deleteProjectMember(Integer id);
}
