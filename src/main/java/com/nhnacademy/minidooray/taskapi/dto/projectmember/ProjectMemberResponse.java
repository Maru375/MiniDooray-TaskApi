package com.nhnacademy.minidooray.taskapi.dto.projectmember;

import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;
import com.nhnacademy.minidooray.taskapi.enums.AuthType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberResponse {
    private String memberId;
    private Integer projectId;
    private AuthType authType;

    public ProjectMemberResponse(ProjectMember member) {
        this.memberId = member.getPk().getMemberId();
        this.projectId = member.getPk().getProjectId();
        this.authType = member.getAuthType();
    }
}
