package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.config.JwtTokenProvider;
import com.roomgenius.furniture_recommendation.entity.BoardDTO;
import com.roomgenius.furniture_recommendation.entity.BoardVO;
import com.roomgenius.furniture_recommendation.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;
    private final JwtTokenProvider jwtTokenProvider;

    // ✅ 게시글 등록 (이미지 포함)
    @PostMapping
    public ResponseEntity<Map<String, Object>> insertBoard(
            @Valid @RequestPart("board") BoardDTO dto,
            @RequestPart(value = "images", required = false) List<MultipartFile> images,
            @RequestHeader(value = "Authorization") String token) {

        log.info("📌 게시글 등록 요청: {}", dto);

        Map<String, Object> response = new HashMap<>();

        // 🔹 1. 토큰에서 이메일 추출
        String tokenValue = token.substring(7);
        String emailFromToken = jwtTokenProvider.getEmailFromToken(tokenValue);
        dto.setEmail(emailFromToken);

        // 🔹 2. 게시글 등록
        int result = boardService.insert(dto, images);

        if (result > 0) {
            response.put("success", true);
            response.put("message", "게시글 등록 성공!");
            response.put("data", dto);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "게시글 등록 실패!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    // ✅ 게시글 전체 조회
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllBoards() {
        List<BoardVO> boards = boardService.selectAll();
        Map<String, Object> response = new HashMap<>();

        response.put("success", true);
        response.put("count", boards.size());
        response.put("data", boards);

        return ResponseEntity.ok(response);
    }

    // ✅ 게시글 상세 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<Map<String, Object>> getBoardById(@PathVariable int boardId) {
        BoardVO board = boardService.selectById(boardId);
        Map<String, Object> response = new HashMap<>();

        if (board == null) {
            response.put("success", false);
            response.put("message", "존재하지 않는 게시글입니다.");
            return ResponseEntity.badRequest().body(response);
        }

        response.put("success", true);
        response.put("data", board);

        return ResponseEntity.ok(response);
    }

    // ✅ 게시글 수정 (이미지 포함)
    @PutMapping("/{boardId}")
    public ResponseEntity<Map<String, Object>> updateBoard(
            @PathVariable int boardId,
            @Valid @RequestPart("board") BoardDTO dto,
            @RequestPart(value = "images", required = false) List<MultipartFile> images,
            @RequestHeader(value = "Authorization") String token) {

        Map<String, Object> response = new HashMap<>();

        // 🔹 1. JWT에서 이메일 추출
        String tokenValue = token.substring(7);
        String emailFromToken = jwtTokenProvider.getEmailFromToken(tokenValue);

        // 🔹 2. 기존 게시글 조회
        BoardVO existing = boardService.selectById(boardId);
        if (existing == null) {
            response.put("success", false);
            response.put("message", "존재하지 않는 게시글입니다.");
            return ResponseEntity.badRequest().body(response);
        }

        // 🔹 3. 작성자 확인 (이메일 비교)
        if (!emailFromToken.equals(existing.getEmail())) {
            response.put("success", false);
            response.put("message", "본인 게시글만 수정할 수 있습니다.");
            return ResponseEntity.status(403).body(response);
        }

        // 🔹 4. 수정 처리
        dto.setBoardId(boardId);
        int result = boardService.update(dto, images);

        response.put("success", result > 0);
        response.put("message", result > 0 ? "게시글 수정 성공" : "게시글 수정 실패");
        return ResponseEntity.ok(response);
    }

    // ✅ 게시글 삭제
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Map<String, Object>> deleteBoard(
            @PathVariable int boardId,
            @RequestHeader(value = "Authorization") String token) {

        Map<String, Object> response = new HashMap<>();

        // 🔹 1. JWT에서 이메일 추출
        String tokenValue = token.substring(7);
        String emailFromToken = jwtTokenProvider.getEmailFromToken(tokenValue);

        // 🔹 2. 기존 게시글 조회
        BoardVO existing = boardService.selectById(boardId);
        if (existing == null) {
            response.put("success", false);
            response.put("message", "존재하지 않는 게시글입니다.");
            return ResponseEntity.badRequest().body(response);
        }

        // 🔹 3. 작성자 검증
        if (!emailFromToken.equals(existing.getEmail())) {
            response.put("success", false);
            response.put("message", "본인 게시글만 삭제할 수 있습니다.");
            return ResponseEntity.status(403).body(response);
        }

        // 🔹 4. 삭제 처리
        int result = boardService.delete(boardId);

        response.put("success", result > 0);
        response.put("message", result > 0 ? "게시글 삭제 성공" : "게시글 삭제 실패");
        return ResponseEntity.ok(response);
    }
}
