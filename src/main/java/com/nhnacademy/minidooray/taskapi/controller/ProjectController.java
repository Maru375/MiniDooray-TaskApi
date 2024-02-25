package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.dto.project.ProjectCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectNameResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectResponse;
import com.nhnacademy.minidooray.taskapi.dto.project.ProjectUpdateRequest;
import com.nhnacademy.minidooray.taskapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService service;

    @GetMapping
    public List<ProjectNameResponse> getProjects(@RequestHeader("X-USER-ID") String userId) {
        return service.getProjects(userId);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Integer projectId) {
        ProjectResponse response = service.getProject(projectId);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestHeader("X-USER-ID") String userId, @RequestBody ProjectCreateRequest projectCreateRequest) {
        ProjectResponse response = service.createProject(userId, projectCreateRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Integer projectId, @RequestBody ProjectUpdateRequest projectUpdateRequest) {
        ProjectResponse response = service.updateProject(projectId, projectUpdateRequest);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{projectId}")
    public ResultResponse deleteProject(@PathVariable Integer projectId) {
        service.deleteProject(projectId);
        return new ResultResponse("DELETE OK");
    }
}
