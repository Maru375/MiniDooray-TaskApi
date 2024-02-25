package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberAddRequest;
import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberResponse;

public interface ProjectMemberService {

    ProjectMemberResponse addProjectMember(Integer projectId, ProjectMemberAddRequest projectMember);

    void deleteProjectMember(String memberId, Integer projectId);
}
