package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.dto.comment.CommentCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentResponse;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentUpdateRequest;
import com.nhnacademy.minidooray.taskapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/{taskId}/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> getProjects(@PathVariable Integer taskId) {
        return commentService.getComments(taskId);
    }

    @PutMapping
    public ResponseEntity<CommentResponse> createTask(@PathVariable Integer taskId, @RequestBody CommentCreateRequest commentCreateRequest){
        CommentResponse comment = commentService.createComment(taskId, commentCreateRequest);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/{commentId}")
    public ResponseEntity<CommentResponse> updateTask(@PathVariable Integer commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        CommentResponse commentResponse = commentService.updateComment(commentId, commentUpdateRequest);
        if (commentResponse != null) {
            return ResponseEntity.ok(commentResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{commentId}")
    public ResultResponse deleteTask(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return new ResultResponse("DELETE OK");
    }
}
