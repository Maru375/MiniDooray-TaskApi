package com.nhnacademy.minidooray.taskapi.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "milestones")
public class Milestone {

    @Id
    @Column(name = "milestone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer milestoneId;

    private String name;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
