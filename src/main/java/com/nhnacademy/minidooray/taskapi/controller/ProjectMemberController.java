package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberAddRequest;
import com.nhnacademy.minidooray.taskapi.dto.projectmember.ProjectMemberResponse;
import com.nhnacademy.minidooray.taskapi.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/{projectId}/member")
public class ProjectMemberController {

    private final ProjectMemberService memberService;

    @PutMapping
    public ResponseEntity<ProjectMemberResponse> addMember(@PathVariable Integer projectId, @RequestBody ProjectMemberAddRequest memberAddRequest){

        ProjectMemberResponse memberResponse = memberService.addProjectMember(projectId, memberAddRequest);
        return ResponseEntity.ok(memberResponse);
    }

    @DeleteMapping("/{memberId}")
    public ResultResponse deleteTask(@PathVariable String memberId, @PathVariable Integer projectId) {
        memberService.deleteProjectMember(memberId, projectId);
        return new ResultResponse("DELETE OK");
    }
}
