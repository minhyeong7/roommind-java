package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.BoardDTO;
import com.roomgenius.furniture_recommendation.entity.BoardVO;
import com.roomgenius.furniture_recommendation.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    // 게시글 등록
    @Override
    @Transactional
    public int insert(BoardDTO dto) {
        try {
            log.info("📌 게시글 등록 요청: {}", dto);

            // 필수 입력값 검증
            validateBoardDTO(dto);

            BoardVO vo = new BoardVO();
            vo.setUserId(dto.getUserId());
            vo.setTitle(dto.getTitle());
            vo.setContent(dto.getContent());
            vo.setImageUrls(dto.getImageUrls());

            int result = boardMapper.insert(vo);

            if (result == 0) {
                throw new RuntimeException("게시글 등록에 실패했습니다.");
            }

            log.info("✅ 게시글 등록 성공: boardId={}", vo.getBoardId());
            return result;

        } catch (IllegalArgumentException e) {
            log.error("❌ 입력값 검증 실패: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("❌ 게시글 등록 중 오류 발생: {}", e.getMessage(), e);
            throw new RuntimeException("게시글 등록 중 오류가 발생했습니다.", e);
        }
    }

    // 게시글 전체 조회
    @Override
    public List<BoardVO> selectAll() {
        try {
            log.info("📌 게시글 전체 조회 요청");
            List<BoardVO> boards = boardMapper.selectAll();

            if (boards == null || boards.isEmpty()) {
                log.info("ℹ️ 조회된 게시글이 없습니다.");
            } else {
                log.info("✅ 게시글 {} 건 조회 완료", boards.size());
            }

            return boards;

        } catch (Exception e) {
            log.error("❌ 게시글 전체 조회 중 오류 발생: {}", e.getMessage(), e);
            throw new RuntimeException("게시글 조회 중 오류가 발생했습니다.", e);
        }
    }

    // 게시글 상세 조회
    @Override
    public BoardVO selectById(int boardId) {
        try {
            log.info("📌 게시글 상세 조회 요청: boardId={}", boardId);

            // boardId 검증
            if (boardId <= 0) {
                throw new IllegalArgumentException("유효하지 않은 게시글 ID입니다.");
            }

            BoardVO board = boardMapper.selectById(boardId);

            if (board == null) {
                log.warn("⚠️ 게시글을 찾을 수 없습니다: boardId={}", boardId);
                throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
            }

            log.info("✅ 게시글 조회 성공: boardId={}", boardId);
            return board;

        } catch (IllegalArgumentException e) {
            log.error("❌ 게시글 조회 실패: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("❌ 게시글 상세 조회 중 오류 발생: boardId={}, error={}", boardId, e.getMessage(), e);
            throw new RuntimeException("게시글 조회 중 오류가 발생했습니다.", e);
        }
    }

    // 게시글 수정
    @Override
    @Transactional
    public int update(BoardDTO dto) {
        try {
            log.info("📌 게시글 수정 요청: {}", dto);

            // 필수 입력값 검증
            if (dto.getBoardId() <= 0) {
                throw new IllegalArgumentException("유효하지 않은 게시글 ID입니다.");
            }
            validateBoardDTO(dto);

            // 게시글 존재 여부 확인
            BoardVO existingBoard = boardMapper.selectById(dto.getBoardId());
            if (existingBoard == null) {
                throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
            }

            BoardVO vo = new BoardVO();
            vo.setBoardId(dto.getBoardId());
            vo.setTitle(dto.getTitle());
            vo.setContent(dto.getContent());
            vo.setImageUrls(dto.getImageUrls());

            int result = boardMapper.update(vo);

            if (result == 0) {
                throw new RuntimeException("게시글 수정에 실패했습니다.");
            }

            log.info("✅ 게시글 수정 성공: boardId={}", dto.getBoardId());
            return result;

        } catch (IllegalArgumentException e) {
            log.error("❌ 입력값 검증 실패: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("❌ 게시글 수정 중 오류 발생: boardId={}, error={}", dto.getBoardId(), e.getMessage(), e);
            throw new RuntimeException("게시글 수정 중 오류가 발생했습니다.", e);
        }
    }

    // 게시글 삭제
    @Override
    @Transactional
    public int delete(int boardId) {
        try {
            log.info("📌 게시글 삭제 요청: boardId={}", boardId);

            // boardId 검증
            if (boardId <= 0) {
                throw new IllegalArgumentException("유효하지 않은 게시글 ID입니다.");
            }

            // 게시글 존재 여부 확인
            BoardVO existingBoard = boardMapper.selectById(boardId);
            if (existingBoard == null) {
                throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
            }

            int result = boardMapper.delete(boardId);

            if (result == 0) {
                throw new RuntimeException("게시글 삭제에 실패했습니다.");
            }

            log.info("✅ 게시글 삭제 성공: boardId={}", boardId);
            return result;

        } catch (IllegalArgumentException e) {
            log.error("❌ 게시글 삭제 실패: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("❌ 게시글 삭제 중 오류 발생: boardId={}, error={}", boardId, e.getMessage(), e);
            throw new RuntimeException("게시글 삭제 중 오류가 발생했습니다.", e);
        }
    }

    // 입력값 검증 메서드
    private void validateBoardDTO(BoardDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("게시글 정보가 없습니다.");
        }

        // userId 검증 (int 타입인 경우)
        if (dto.getUserId() <= 0) {
            throw new IllegalArgumentException("사용자 ID는 필수입니다.");
        }

        // title 검증 (null 체크 후 길이 검증)
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
        if (dto.getTitle().length() > 200) {
            throw new IllegalArgumentException("제목은 200자를 초과할 수 없습니다.");
        }

        // content 검증
        if (dto.getContent() == null || dto.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("내용은 필수입니다.");
        }
    }
}