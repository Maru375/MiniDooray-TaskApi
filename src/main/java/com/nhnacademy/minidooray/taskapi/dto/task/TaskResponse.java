package com.nhnacademy.minidooray.taskapi.dto.task;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;
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
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    @NotNull
    private String taskName;
    private String taskContent;
    @NotNull
    private ProjectMember managerId;
    private Tag tag;
    private Milestone milestone;
    private TaskState taskState;
    @NotNull
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public TaskResponse(Task task) {
        this.taskName = task.getTaskName();
        this.taskContent = task.getTaskContent();
        this.managerId = task.getManagerId();
        this.tag = task.getTag();
        this.milestone = task.getMilestone();
        this.taskState = task.getTaskState();
        this.createdAt = task.getCreatedAt();
        this.modifiedAt = task.getModifiedAt();
    }
}
