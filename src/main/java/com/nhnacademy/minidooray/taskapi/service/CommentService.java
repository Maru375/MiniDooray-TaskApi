package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.dto.comment.CommentRequest;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentResponse;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getComments(Integer id);

    CommentResponse createComment(CommentRequest commentRequest);

    void deleteComment(Integer id);
}
