package com.nhnacademy.minidooray.taskapi.dto.project;

import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.dto.task.TaskNameResponse;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSimpleResponse {

    @NotNull
    private String projectName;

    private List<TaskNameResponse> taskName;

    @Builder
    public ProjectSimpleResponse(Project project, List<TaskNameResponse> taskNameResponse) {
        this.projectName = project.getProjectName();
        this.taskName = taskNameResponse;
    }
}
