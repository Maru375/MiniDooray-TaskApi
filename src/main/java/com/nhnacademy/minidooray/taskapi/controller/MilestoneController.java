package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneResponse;
import com.nhnacademy.minidooray.taskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/milestones")
public class MilestoneController {
    private final MilestoneService milestoneService;

    @GetMapping
    public List<MilestoneResponse> getMilestones() {
        return milestoneService.getMilestones();
    }

    @GetMapping("/{id}")
    public MilestoneResponse getMilestone(@PathVariable Integer id) {
        return milestoneService.getMilestone(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MilestoneResponse createMilestone(@RequestBody MilestoneCreateRequest milestoneCreateRequest) {
        return milestoneService.createMilestone(milestoneCreateRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteMilestone(@PathVariable Integer id) {
        milestoneService.deleteMilestone(id);
        return "{\"result\": \"OK\"}";
    }
}
