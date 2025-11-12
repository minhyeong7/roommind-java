package com.roomgenius.furniture_recommendation.entity;

import lombok.*;

@Getter  // 각 필드의 getter 메서드 자동 생성
@Setter  // 각 필드의 setter 메서드 자동 생성
@ToString  // 객체 정보를 보기 쉽게 문자열로 변환하는 toString() 자동 생성
@Builder  // 객체 생성 시 빌더 패턴을 자동 생성 (ex: User.builder().name("노아").age(25).build())
@NoArgsConstructor  // 파라미터가 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 자동 생성
public class BoardVO {

    private int boardId;      // 게시글 번호 (Boards.boardId)
    private int userId;       // 작성자 ID (외래키)
    private String title;     // 제목
    private String content;   // 내용
    private String imageUrls; // 이미지 경로
    private int commentCount; // 댓글 수
    private int likeCount;    // 좋아요 수
    private String createdDate; // 작성일
    private String updatedDate; // 수정일

    // 화면 출력용 (JOIN 시 추가)
    private String username;  // 작성자 이름 (Users.username)
}
