package com.nhnacademy.minidooray.taskapi.domain;

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
@Table(name = "Projects")
public class Project{

    @Id
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_content")
    private String projectContent;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tagId;

    @OneToOne
    @JoinColumn(name = "milesotone_id")
    private Milestone milestoneId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}
