package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Comment;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentCreateRequest;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentResponse;
import com.nhnacademy.minidooray.taskapi.dto.comment.CommentUpdateRequest;
import com.nhnacademy.minidooray.taskapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Override
    public List<CommentResponse> getComments(Integer id) {
        return commentRepository.findAllByTask_TaskId(id);
    }

    @Override
    public CommentResponse createComment(Integer taskId, CommentCreateRequest commentCreateRequest) {
        return new CommentResponse(commentRepository.save(commentCreateRequest.toEntity(taskId)));
    }

    @Override
    public CommentResponse updateComment(Integer id, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id : " + id + "는 찾을 수 없는 코멘트 입니다."));

        if(comment != null){
            comment.setCommentContent(commentUpdateRequest.getCommentsContent());
            comment.setModifiedAt(LocalDateTime.now());
            return new CommentResponse(commentRepository.save(comment));
        }
        return null;
    }

    @Override
    public void deleteComment(Integer id) {
        if (!commentRepository.existsById(id)) {
            throw new IllegalArgumentException("id : " + id + "는 찾을 수 없는 아이디 입니다.");
        }
        commentRepository.deleteById(id);
    }
}
