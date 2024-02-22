package com.nhnacademy.minidooray.taskapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Integer milestoneId;

    private String name;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "end_date")
    private LocalDateTime endDate;

}
