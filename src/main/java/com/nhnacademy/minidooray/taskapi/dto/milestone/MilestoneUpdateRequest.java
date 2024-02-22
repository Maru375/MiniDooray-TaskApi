package com.nhnacademy.minidooray.taskapi.dto.milestone;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MilestoneUpdateRequest {

    @NotNull
    private Integer milestoneId;
    private String name;
    private LocalDateTime startedAt;
    @NotNull
    private LocalDateTime endDate;

    public Milestone toEntity(){
        return Milestone.builder()
                .milestoneId(milestoneId)
                .name(name)
                .startedAt(startedAt)
                .endDate(endDate)
                .build();
    }
}
