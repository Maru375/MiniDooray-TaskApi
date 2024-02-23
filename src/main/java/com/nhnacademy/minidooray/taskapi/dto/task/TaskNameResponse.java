package com.nhnacademy.minidooray.taskapi.dto.task;

import com.nhnacademy.minidooray.taskapi.domain.Task;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskNameResponse {

    @NotNull
    private Integer taskId;

    @NotNull
    private String tasName;

    @Builder
    public TaskNameResponse(Task task) {
        this.taskId = task.getTaskId();
        this.tasName = task.getTaskName();
    }
}
