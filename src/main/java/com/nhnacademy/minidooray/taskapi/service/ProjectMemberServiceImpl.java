package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.ProjectMember;
import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberAddRequest;
import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberResponse;
import com.nhnacademy.minidooray.taskapi.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService{

    private final ProjectMemberRepository memberRepository;

    @Override
    public ProjectMemberResponse addProjectMember(Integer projectId, ProjectMemberAddRequest projectMember) {
        return new ProjectMemberResponse(memberRepository.save(projectMember.toEntity(projectId)));
    }

    @Override
    public void deleteProjectMember(String memberId, Integer projectId) {
        ProjectMember.Pk projectMemberID = new ProjectMember.Pk(memberId, projectId);
        if (!memberRepository.existsById(projectMemberID)) {
            throw new IllegalArgumentException("찾을 수 없는 멤버 입니다.");
        }
        memberRepository.deleteById(projectMemberID);
    }
}
