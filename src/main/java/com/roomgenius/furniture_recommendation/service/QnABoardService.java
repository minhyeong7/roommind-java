package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.QnABoardDTO;
import com.roomgenius.furniture_recommendation.entity.QnABoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QnABoardService {

    // 게시글 등록 (이미지 포함)
    int insert(QnABoardDTO dto, List<MultipartFile> images);

    // 게시글 전체 조회
    List<QnABoardVO> selectAll();

    // 게시글 상세 조회
    QnABoardVO selectById(int boardId);

    // 게시글 수정 (이미지 포함)
    int update(QnABoardDTO dto, List<MultipartFile> images);

    // 게시글 삭제
    int delete(int boardId);
}