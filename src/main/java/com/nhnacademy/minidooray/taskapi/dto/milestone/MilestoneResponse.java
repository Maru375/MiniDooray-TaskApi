package com.nhnacademy.minidooray.taskapi.dto.milestone;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MilestoneResponse {

    @NotNull
    private String name;
    @NotNull
    private LocalDateTime startedAt;
    private LocalDateTime endDate;

    @Builder
    public MilestoneResponse(Milestone milestone) {
        this.name = milestone.getName();
        this.startedAt = milestone.getStartedAt();
        this.endDate = milestone.getEndDate();
    }
}
