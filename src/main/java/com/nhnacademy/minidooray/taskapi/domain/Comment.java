package com.nhnacademy.minidooray.taskapi.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String name;

    @Column(name = "comments_content")
    private String commentContent;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Comment(Integer commentId, Task task, String name, String commentContent, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.commentId = commentId;
        this.task = task;
        this.name = name;
        this.commentContent = commentContent;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
