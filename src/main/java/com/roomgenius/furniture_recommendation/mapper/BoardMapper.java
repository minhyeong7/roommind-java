package com.roomgenius.furniture_recommendation.mapper;


import com.roomgenius.furniture_recommendation.entity.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 등록
    int insert(BoardVO bvo);

    // 게시글 전체 조회
    List<BoardVO> selectAll();

    // 게시글 상세 조회
    BoardVO selectById(@Param("boardId") int boardId);

    // 게시글 수정
    int update(BoardVO bvo);

    // 게시글 삭제
    int delete(@Param("boardId") int boardId);
}

