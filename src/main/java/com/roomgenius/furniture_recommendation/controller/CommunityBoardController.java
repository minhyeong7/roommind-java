package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.config.JwtTokenProvider;
import com.roomgenius.furniture_recommendation.entity.CommunityBoardDTO;
import com.roomgenius.furniture_recommendation.entity.CommunityBoardVO;
import com.roomgenius.furniture_recommendation.entity.FileVO;
import com.roomgenius.furniture_recommendation.entity.UserVO;
import com.roomgenius.furniture_recommendation.service.CommunityBoardService;
import com.roomgenius.furniture_recommendation.service.FileService;
import com.roomgenius.furniture_recommendation.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/community")
public class CommunityBoardController {

    private final CommunityBoardService communityBoardService;
    private final FileService fileService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    /** ==================== 게시글 등록 ==================== */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> insertBoard(
            @Valid @RequestPart("board") CommunityBoardDTO dto,
            @RequestPart(value = "images", required = false) List<MultipartFile> images,
            @RequestHeader("Authorization") String tokenHeader) {

        // JWT → email
        String email = jwtTokenProvider.getEmailFromToken(tokenHeader.substring(7));

        UserVO user = userService.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }

        dto.setUserId(user.getUserId());

        // 게시글 등록 → boardId 반환
        Integer boardId = communityBoardService.insert(dto);

        // 이미지 저장
        if (images != null && !images.isEmpty()) {
            fileService.uploadCommunityFiles(boardId, images);
        }

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "게시글 등록 성공",
                "boardId", boardId,
                "fileCount", images != null ? images.size() : 0
        ));
    }

    /** ==================== 전체 조회 ==================== */
    @GetMapping
    public ResponseEntity<?> getAllBoards() {

        List<CommunityBoardVO> list = communityBoardService.selectAll();

        return ResponseEntity.ok(Map.of(
                "success", true,
                "count", list.size(),
                "data", list
        ));
    }

    /** ==================== 상세 조회 ==================== */
    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoardById(@PathVariable int boardId) {

        CommunityBoardVO board = communityBoardService.selectById(boardId);

        List<FileVO> files = fileService.getCommunityFiles(boardId);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "data", Map.of(
                        "board", board,
                        "files", files
                )
        ));
    }

    /** ==================== 게시글 수정 ==================== */
    @PutMapping(value = "/{boardId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateBoard(
            @PathVariable int boardId,
            @Valid @RequestPart("board") CommunityBoardDTO dto,
            @RequestPart(value = "images", required = false) List<MultipartFile> images,
            @RequestHeader("Authorization") String tokenHeader) {

        String email = jwtTokenProvider.getEmailFromToken(tokenHeader.substring(7));

        UserVO user = userService.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }

        dto.setCommunityBoardId(boardId);

        // 본인 검증 + 수정
        communityBoardService.update(dto, user.getUserId());

        // 이미지 교체
        boolean replaced = false;

        if (images != null && !images.isEmpty()) {
            replaced = true;
            fileService.deleteCommunityFiles(boardId);
            fileService.uploadCommunityFiles(boardId, images);
        }

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "게시글 수정 성공",
                "imagesReplaced", replaced
        ));
    }

    /** ==================== 게시글 삭제 ==================== */
    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(
            @PathVariable int boardId,
            @RequestHeader("Authorization") String tokenHeader) {

        String email = jwtTokenProvider.getEmailFromToken(tokenHeader.substring(7));

        UserVO user = userService.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }

        communityBoardService.delete(boardId, user.getUserId());

        fileService.deleteCommunityFiles(boardId);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "게시글 삭제 성공"
        ));
    }
}
