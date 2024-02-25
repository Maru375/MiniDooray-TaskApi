package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;
import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberAddRequest;
import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberResponse;

import java.util.List;

public interface ProjectMemberService {

    ProjectMemberResponse addProjectMember(Integer projectId, ProjectMemberAddRequest projectMember);

    void deleteProjectMember(String memberId, Integer projectId);
}
