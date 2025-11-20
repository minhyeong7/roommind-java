package com.roomgenius.furniture_recommendation.mapper;

import com.roomgenius.furniture_recommendation.entity.CommunityBoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    // 게시글 등록
    int insert(CommunityBoardVO bvo);

    // 게시글 전체 조회
    List<CommunityBoardVO> selectAll();

    // 게시글 상세 조회
    CommunityBoardVO selectById(@Param("communityBoardId") Integer communityBoardId);

    // 게시글 수정
    int update(CommunityBoardVO bvo);

    // 게시글 삭제
    int delete(@Param("communityBoardId") Integer communityBoardId);
}
