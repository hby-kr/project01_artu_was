package com.artu.service.postings;

import com.artu.dto.posting.PostingCommentDto;
import com.artu.entity.postings.PostingComment;
import com.artu.mapper.posting.PostingCommentMapper;
import com.artu.repository.postings.PostingCommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostingCommentServiceImp implements PostingCommentService {
    private final PostingCommentsRepository postingCommentsRepository;
    private final PostingCommentMapper postingCommentMapper;

    @Override
    public PostingCommentDto.PostingCommentResponseDto save(PostingCommentDto.PostingCommentRequestDto postingCommentRequestDto) {
        PostingComment postingComment = postingCommentMapper.toEntity(postingCommentRequestDto);
//        if (postingComment.getUser() == null || postingComment.getUser().getUserNo() == null) {
//            throw new IllegalArgumentException("사용자 확인 필요");
//        }
        PostingComment savedPostingComment = postingCommentsRepository.save(postingComment);
        return postingCommentMapper.toResponseDto(savedPostingComment);
    }

    @Override
    public PostingCommentDto.PostingCommentResponseDto delete(Integer commentId) {
        PostingComment postingComment = postingCommentsRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글 없음"));
        postingCommentsRepository.delete(postingComment);
        return postingCommentMapper.toResponseDto(postingComment);
    }

    @Override
    public Set<PostingCommentDto.PostingCommentResponseDto> findByPostId(Integer postId) {
        Set<PostingComment> postingComments = postingCommentsRepository.findByPostId(postId);
        return postingComments.stream()
                .map(postingCommentMapper::toResponseDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<PostingCommentDto.PostingCommentResponseDto> findByCommentId(Integer commentId) {
        return postingCommentsRepository.findById(commentId)
                .map(postingCommentMapper::toResponseDto);
    }

    @Override
    public Set<PostingCommentDto.PostingCommentResponseDto> findByUserNo(Integer userNo) {
        Set<PostingComment> postingComments = postingCommentsRepository.findByUserNo(userNo);
        return postingComments.stream()
                .map(postingCommentMapper::toResponseDto)
                .collect(Collectors.toSet());
    }
}
