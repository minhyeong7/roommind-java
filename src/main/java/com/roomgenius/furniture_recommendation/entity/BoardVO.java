package com.roomgenius.furniture_recommendation.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 게시글 VO (DB 조회 결과)
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
    private Integer boardId;
    private Integer userId;          // FK: Users.userId
    private String username;         // JOIN으로 가져올 작성자 이름
    private String email;            // JOIN으로 가져올 작성자 이메일
    private String title;
    private String content;
    private String imageUrls;        // DB 컬럼명: image_urls (JSON 문자열 또는 쉼표 구분)
    private Integer commentCount;    // DB 컬럼명: comment_count
    private Integer likeCount;       // DB 컬럼명: like_count
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}