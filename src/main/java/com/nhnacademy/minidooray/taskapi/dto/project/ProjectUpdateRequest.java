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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUpdateRequest {
    @NotNull
    private Integer projectId;
    @NotNull
    private String projectName;
    @NotNull
    private String projectContent;
    private Tag tagId;
    private Milestone milestoneId;
    @NotNull
    private LocalDateTime modifiedAt;

    public Project toEntity(){
        return Project.builder()
                .projectId(projectId)
                .projectName(projectName)
                .projectContent(projectContent)
                .tagId(tagId)
                .milestoneId(milestoneId)
                .modifiedAt(modifiedAt)
                .build();
    }
}
