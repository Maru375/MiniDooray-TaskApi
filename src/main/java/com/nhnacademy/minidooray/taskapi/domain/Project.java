package com.nhnacademy.minidooray.taskapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> projectMembers = new ArrayList<>();

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_content")
    private String projectContent;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Project(Integer projectId, String projectName, String projectContent, Tag tag, Milestone milestone, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectContent = projectContent;
        this.tag = tag;
        this.milestone = milestone;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
