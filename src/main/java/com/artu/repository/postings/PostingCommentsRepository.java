package com.artu.repository.postings;

import com.artu.entity.postings.PostingComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostingCommentsRepository  extends JpaRepository<PostingComment, Integer> {
    // 게시물 해당 댓글
    Set<PostingComment> findByPost_PostId(Integer postId);

    // 유저의 댓글
    Set<PostingComment> findByUser_UserNo(Integer userNo);
}
