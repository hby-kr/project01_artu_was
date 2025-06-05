package com.artu.repository.postings;

import com.artu.entity.postings.PostingLike;
import com.artu.entity.postings.PostingLikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostingLikeRepository extends JpaRepository<PostingLike, PostingLikeId> {
    // 유저의 좋아요 목록
    Set<PostingLike> findByUser_UserNo(Integer userNo);

    // 게시물 좋아요 카운트
    Long countPostingLikeByPost_PostId(Integer postId);

}
