package com.nhnacademy.minidooray.taskapi.dto.task;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import com.nhnacademy.minidooray.taskapi.domain.Project;
import com.nhnacademy.minidooray.taskapi.domain.Tag;
import com.nhnacademy.minidooray.taskapi.domain.Task;
import com.nhnacademy.minidooray.taskapi.enums.TaskState;
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
public class TaskCreateRequest {
    @NotNull
    private Project project;
    @NotNull
    private String taskName;
    private String taskContent;
    private Tag tag;
    private Milestone milestone;
    @NotNull
    private String recorder;
    private TaskState taskState;

    public Task toEntity(){
        return Task.builder()
                .project(project)
                .taskName(taskName)
                .taskContent(taskContent)
                .tag(tag)
                .milestone(milestone)
                .recorder(recorder)
                .taskState(taskState)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
