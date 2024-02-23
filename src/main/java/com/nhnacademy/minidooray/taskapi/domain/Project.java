package com.nhnacademy.minidooray.taskapi.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "projects")
public class Project{

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_content")
    private String projectContent;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tagId;

    @OneToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestoneId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;


    @Builder
    public Project(Integer projectId, String projectName, String projectContent, Tag tagId, Milestone milestoneId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectContent = projectContent;
        this.tagId = tagId;
        this.milestoneId = milestoneId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
