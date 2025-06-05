package com.artu.repository.postings;

import com.artu.entity.postings.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Integer> {
    // user의 게시글 조회
    Set<Posting> findByUser_UserNo(Integer userNo);

    // 게시글 조회
    Posting findByPostId(Integer postId);

    // like_count
//    @Query("SELECT COUNT(p.postId) FROM Posting p LEFT JOIN User u ON u.userNo = p.userNo WHERE u.userNo = :userNo")
    Long countPostingsByUser_UserNo(Integer userNo);
}
