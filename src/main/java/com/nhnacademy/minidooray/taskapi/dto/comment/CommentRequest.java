package com.nhnacademy.minidooray.taskapi.dto.comment;

import com.nhnacademy.minidooray.taskapi.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private Integer commentId;
    private Task taskId;
    private String name;
    private String commentsContent;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
