package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.BoardDTO;
import com.roomgenius.furniture_recommendation.entity.BoardVO;
import com.roomgenius.furniture_recommendation.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    // 게시글 등록
    @Override
    public int insert(BoardDTO dto) {
        log.info("📌 게시글 등록 요청: {}", dto);
        BoardVO vo = new BoardVO();
        vo.setUserId(dto.getUserId());
        vo.setTitle(dto.getTitle());
        vo.setContent(dto.getContent());
        vo.setImageUrls(dto.getImageUrls());
        return boardMapper.insert(vo);
    }

    // 게시글 전체 조회
    @Override
    public List<BoardVO> selectAll() {
        log.info("📌 게시글 전체 조회 요청");
        return boardMapper.selectAll();
    }

    // 게시글 상세 조회
    @Override
    public BoardVO selectById(int boardId) {
        log.info("📌 게시글 상세 조회 요청: boardId={}", boardId);
        return boardMapper.selectById(boardId);
    }

    // 게시글 수정
    @Override
    public int update(BoardDTO dto) {
        log.info("📌 게시글 수정 요청: {}", dto);
        BoardVO vo = new BoardVO();
        vo.setBoardId(dto.getBoardId());
        vo.setTitle(dto.getTitle());
        vo.setContent(dto.getContent());
        vo.setImageUrls(dto.getImageUrls());
        return boardMapper.update(vo);
    }

    // 게시글 삭제
    @Override
    public int delete(int boardId) {
        log.info("📌 게시글 삭제 요청: boardId={}", boardId);
        return boardMapper.delete(boardId);
    }
}

