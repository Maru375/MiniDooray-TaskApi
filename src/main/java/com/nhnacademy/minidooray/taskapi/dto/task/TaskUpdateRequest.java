package com.nhnacademy.minidooray.taskapi.dto.task;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import com.nhnacademy.minidooray.taskapi.domain.Tag;
import com.nhnacademy.minidooray.taskapi.enums.TaskState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateRequest {
    private String taskName;
    private String taskContent;
    private Tag tag;
    private Milestone milestone;
    private TaskState taskState;
}
