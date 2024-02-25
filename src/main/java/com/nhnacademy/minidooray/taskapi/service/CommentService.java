package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.comment.CommentCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentResponse;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentUpdateRequest;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getComments(Integer id);

    CommentResponse createComment(CommentCreateRequest commentCreateRequest);

    CommentResponse updateComment(Integer id, CommentUpdateRequest commentUpdateRequest);

    void deleteComment(Integer id);
}
