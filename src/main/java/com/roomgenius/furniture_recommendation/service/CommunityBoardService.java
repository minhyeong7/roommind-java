package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.CommunityBoardDTO;
import com.roomgenius.furniture_recommendation.entity.CommunityBoardVO;

import java.util.List;

public interface CommunityBoardService {

    /** 게시글 등록 */
    Integer insert(CommunityBoardDTO dto);

    /** 게시글 전체 조회 */
    List<CommunityBoardVO> selectAll();

    /** 게시글 상세 조회 */
    CommunityBoardVO selectById(Integer communityBoardId);

    /** 게시글 수정 */
    Integer update(CommunityBoardDTO dto, Integer requestUserId);

    /** 게시글 삭제 */
    Integer delete(Integer communityBoardId, Integer requestUserId);
}
