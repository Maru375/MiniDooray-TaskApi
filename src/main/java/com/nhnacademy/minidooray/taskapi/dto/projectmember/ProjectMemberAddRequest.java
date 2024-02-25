package com.nhnacademy.minidooray.taskapi.dto.projectmember;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;
import com.nhnacademy.minidooray.taskapi.enums.AuthType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberAddRequest {
    private String memberId;
    private AuthType authType;

    public ProjectMember toEntity(Integer id){
        return ProjectMember.builder()
                .project(new Project(id))
                .pk(new ProjectMember.Pk(memberId, id))
                .authType(authType)
                .build();
    }
}
