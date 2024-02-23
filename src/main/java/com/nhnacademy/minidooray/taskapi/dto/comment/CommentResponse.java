package com.nhnacademy.minidooray.taskapi.dto.comment;

import com.nhnacademy.minidooray.taskapi.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private String name;
    private String commentsContent;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
