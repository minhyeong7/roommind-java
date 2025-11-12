package com.roomgenius.furniture_recommendation.service;


import com.roomgenius.furniture_recommendation.entity.BoardVO;
import com.roomgenius.furniture_recommendation.entity.BoardDTO;

import java.util.List;

public interface BoardService {

    // 게시글 등록
    int insert(BoardDTO dto);

    // 게시글 전체 조회
    List<BoardVO> selectAll();

    // 게시글 상세 조회
    BoardVO selectById(int boardId);

    // 게시글 수정
    int update(BoardDTO dto);

    // 게시글 삭제
    int delete(int boardId);
}

