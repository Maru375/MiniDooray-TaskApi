package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneResponse;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneUpdateRequest;

import java.util.List;

public interface MilestoneService {

    List<MilestoneResponse> getMilestones();

    MilestoneResponse getMilestone(Integer id);

    MilestoneResponse createMilestone(MilestoneCreateRequest milestoneCreateRequest);

    MilestoneResponse updateMilestone(MilestoneUpdateRequest milestoneUpdateRequest);

    void deleteMilestone(Integer id);
}
