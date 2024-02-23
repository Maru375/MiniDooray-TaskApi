package com.nhnacademy.minidooray.taskapi.domain;

import com.nhnacademy.minidooray.taskapi.enums.TaskState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JoinColumn(name = "manager_id")
    private ProjectMember projectMember;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private TaskState taskState;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Task(int taskId, ProjectMember projectId, ProjectMember managerId, Tag tag, Milestone milestone, String taskName, String taskContent, TaskState taskState, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.taskId = taskId;
        this.tag = tag;
        this.milestone = milestone;
        this.taskName = taskName;
        this.taskContent = taskContent;
        this.taskState = taskState;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
