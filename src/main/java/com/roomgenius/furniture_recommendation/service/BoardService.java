package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.BoardDTO;
import com.roomgenius.furniture_recommendation.entity.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    // 게시글 등록 (이미지 포함)
    int insert(BoardDTO dto, List<MultipartFile> images);

    // 게시글 전체 조회
    List<BoardVO> selectAll();

    // 게시글 상세 조회
    BoardVO selectById(int boardId);

    // 게시글 수정 (이미지 포함)
    int update(BoardDTO dto, List<MultipartFile> images);

    // 게시글 삭제
    int delete(int boardId);
}