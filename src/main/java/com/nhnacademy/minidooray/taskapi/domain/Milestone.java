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
@Table(name = "milestones")
public class Milestone {

    @Id
    @Column(name = "milesotone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer milestoneId;

    private String name;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "end_date")
    private LocalDateTime endDate;

}
