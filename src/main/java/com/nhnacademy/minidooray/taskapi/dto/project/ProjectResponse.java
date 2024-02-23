package com.nhnacademy.minidooray.taskapi.dto.project;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    @NotNull
    private String projectName;

    private String projectContent;

    private Tag tagId;

    private Milestone milestoneId;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @Builder
    public ProjectResponse(Project project) {
        this.projectName = project.getProjectName();
        this.projectContent = project.getProjectContent();
        this.tagId = project.getTagId();
        this.milestoneId = project.getMilestoneId();
        this.createdAt = project.getCreatedAt();
        this.modifiedAt = project.getModifiedAt();
    }
}
