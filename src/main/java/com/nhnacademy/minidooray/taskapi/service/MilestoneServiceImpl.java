package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Milestone;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneResponse;
import com.nhnacademy.minidooray.taskapi.dto.milestone.MilestoneUpdateRequest;
import com.nhnacademy.minidooray.taskapi.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneRepository milestoneRepository;

    public MilestoneServiceImpl(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    @Override
    public List<MilestoneResponse> getMilestones() {
        List<Milestone> milestones = milestoneRepository.findAll();

        if (milestones.isEmpty()) {
            return Collections.emptyList();
        }
        return milestones.stream()
                .map(MilestoneResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public MilestoneResponse getMilestone(Integer id) {
        Milestone milestone = milestoneRepository.findById(id).orElse(null);
        if (milestone == null) {
            return null;
        }
        return new MilestoneResponse(milestone);
    }

    @Override
    public MilestoneResponse createMilestone(MilestoneCreateRequest milestoneCreateRequest) {
        return new MilestoneResponse(milestoneRepository.save(milestoneCreateRequest.toEntity()));
    }

    @Override
    public MilestoneResponse updateMilestone(MilestoneUpdateRequest milestoneUpdateRequest) {
        return new MilestoneResponse(milestoneRepository.save(milestoneUpdateRequest.toEntity()));
    }

    @Override
    public void deleteMilestone(Integer id) {
        if(!milestoneRepository.existsById(id)) {
            throw new IllegalArgumentException("id : 마일스톤 "+ id + "는 찾을 수 없는 마일스톤 아이디 입니다.");
        }
        milestoneRepository.deleteById(id);
    }
}
