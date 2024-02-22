package com.nhnacademy.minidooray.taskapi.domain;

import com.nhnacademy.minidooray.taskapi.enums.TaskState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectMember projectId;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ProjectMember managerId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @Column(name = "task_name")
    private String tasName;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private TaskState taskState;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}
