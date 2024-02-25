package com.nhnacademy.minidooray.taskapi.repository;

import com.nhnacademy.minidooray.taskapi.domain.Comment;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<CommentResponse> findAllByTask_TaskId(Integer id);
}
