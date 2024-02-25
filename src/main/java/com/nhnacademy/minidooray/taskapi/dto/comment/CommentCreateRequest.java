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

    public Comment toEntity(Integer id) {
        return Comment.builder()
                .task(new Task(id))
                .name(name)
                .commentContent(commentContent)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
