package com.nhnacademy.minidooray.taskapi.dto.task;

import com.nhnacademy.minidooray.taskapi.domain.*;
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
    private int taskId;
    @NotNull
    private Project projectId;
    @NotNull
    private String taskName;
    private String taskContent;
    private Tag tag;
    private Milestone milestone;
    @NotNull
    private String recorder;
    private TaskState taskState;
    @NotNull
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public TaskResponse(Task task) {
        this.taskId = task.getTaskId();
        this.projectId = task.getProjectId();
        this.taskName = task.getTaskName();
        this.taskContent = task.getTaskContent();
        this.tag = task.getTag();
        this.milestone = task.getMilestone();
        this.recorder = task.getRecorder();
        this.taskState = task.getTaskState();
        this.createdAt = task.getCreatedAt();
        this.modifiedAt = task.getModifiedAt();
    }
}
