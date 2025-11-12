package com.roomgenius.furniture_recommendation.entity;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class BoardDTO {

    private int boardId;        // 게시글 번호
    private int userId;         // 작성자 ID (외래키)
    private String title;       // 제목
    private String content;     // 내용
    private String imageUrls;   // 이미지 경로
    private int commentCount;   // 댓글 수
    private int likeCount;      // 좋아요 수
    private String createdDate; // 작성일
    private String updatedDate; // 수정일

    // 화면 출력용 (조인 시 Users.username)
    private String username;    // 작성자 이름
}