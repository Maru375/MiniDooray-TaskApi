package com.nhnacademy.minidooray.taskapi.dto.project;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSimpleResponse {
    @NotNull
    Integer projectId;
    @NotNull
    String projectName;

    @Builder
    public ProjectSimpleResponse(Project project) {
        this.projectId = project.getProjectId();
        this.projectName = project.getProjectName();
    }
}
