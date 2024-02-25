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
    public List<ProjectNameResponse> getProjects(@RequestHeader("X-USER-ID") String id) {
        return service.getProjects(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Integer id) {
        ProjectResponse response = service.getProject(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectCreateRequest projectCreateRequest) {
        ProjectResponse response = service.createProject(projectCreateRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Integer id, @RequestBody ProjectUpdateRequest projectUpdateRequest) {
        ProjectResponse response = service.updateProject(id, projectUpdateRequest);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResultResponse deleteAccount(@PathVariable("id") Integer id) {
        service.deleteProject(id);
        return new ResultResponse("DELETE OK");
    }
}
