package com.roomgenius.furniture_recommendation.entity;


import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileVO {

    private String uuid;              // PK

    // FK (nullable) - 세 종류 게시판/상품 중 하나만 연결됨
    private Integer qnaBoardId;
    private Integer productId;
    private Integer communityBoardId;

    private String saveDir;           // 저장 디렉토리
    private String fileName;          // 실제 파일 이름
    private Integer fileType;         // 0=일반, 1=썸네일 등
    private Long fileSize;            // 파일 크기

    private LocalDateTime createdDate;
}

