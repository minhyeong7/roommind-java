package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.entity.BoardDTO;
import com.roomgenius.furniture_recommendation.entity.BoardVO;
import com.roomgenius.furniture_recommendation.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    // 1️⃣ 게시글 등록
    @PostMapping
    public int insertBoard(@RequestBody BoardDTO dto) {
        log.info("📌 게시글 등록 요청: {}", dto);
        return boardService.insert(dto);
    }

    // 2️⃣ 게시글 전체 조회
    @GetMapping
    public List<BoardVO> getAllBoards() {
        log.info("📌 게시글 전체 조회 요청");
        return boardService.selectAll();
    }

    // 3️⃣ 게시글 상세 조회
    @GetMapping("/{boardId}")
    public BoardVO getBoardById(@PathVariable int boardId) {
        log.info("📌 게시글 상세 조회 요청: {}", boardId);
        return boardService.selectById(boardId);
    }

    // 4️⃣ 게시글 수정
    @PutMapping("/{boardId}")
    public int updateBoard(@PathVariable int boardId, @RequestBody BoardDTO dto) {
        dto.setBoardId(boardId);
        log.info("📌 게시글 수정 요청: {}", dto);
        return boardService.update(dto);
    }

    // 5️⃣ 게시글 삭제
    @DeleteMapping("/{boardId}")
    public int deleteBoard(@PathVariable int boardId) {
        log.info("📌 게시글 삭제 요청: {}", boardId);
        return boardService.delete(boardId);
    }
}

