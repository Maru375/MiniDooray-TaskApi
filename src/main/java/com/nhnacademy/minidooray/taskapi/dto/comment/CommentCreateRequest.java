package com.nhnacademy.minidooray.taskapi.dto.comment;

import com.nhnacademy.minidooray.taskapi.domain.Comment;
import com.nhnacademy.minidooray.taskapi.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequest {
    private Task task;
    private String name;
    private String commentContent;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Comment toEntity() {
        return Comment.builder()
                .task(task)
                .name(name)
                .commentContent(commentContent)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
