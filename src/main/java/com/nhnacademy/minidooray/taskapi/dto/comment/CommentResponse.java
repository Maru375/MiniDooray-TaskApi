package com.nhnacademy.minidooray.taskapi.dto.comment;

import com.nhnacademy.minidooray.taskapi.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    @NotNull
    private Integer commentId;
    @NotNull
    private String name;
    private String commentContent;
    @NotNull
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.name = comment.getName();
        this.commentContent = comment.getCommentContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
