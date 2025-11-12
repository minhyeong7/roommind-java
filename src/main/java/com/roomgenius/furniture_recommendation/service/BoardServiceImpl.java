package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.BoardDTO;
import com.roomgenius.furniture_recommendation.entity.BoardVO;
import com.roomgenius.furniture_recommendation.entity.MemberVO;
import com.roomgenius.furniture_recommendation.mapper.BoardMapper;
import com.roomgenius.furniture_recommendation.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final MemberMapper memberMapper;

    /**
     * ✅ 게시글 등록 (이미지 업로드 포함)
     */
    @Override
    @Transactional
    public int insert(BoardDTO dto, List<MultipartFile> images) {
        try {
            log.info("📌 게시글 등록 요청: {}", dto);
            validateBoardDTO(dto);

            // 이메일 → 회원 조회
            MemberVO member = memberMapper.findByEmail(dto.getEmail());
            if (member == null) {
                throw new IllegalArgumentException("유효하지 않은 사용자입니다.");
            }

            // 단일 이미지 업로드 (형식 검증 포함)
            String imageUrl = uploadImage(images); // ❗ 형식/확장자 오류 시 IllegalArgumentException 발생

            // DB 저장
            BoardVO vo = BoardVO.builder()
                    .userId(member.getUserId())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .imageUrls(imageUrl)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            int result = boardMapper.insert(vo);
            if (result == 0) throw new RuntimeException("게시글 등록 실패");
            log.info("✅ 게시글 등록 완료: {}", vo);
            return result;

        } catch (IllegalArgumentException e) {
            // 전역 예외 처리기에서 400으로 내려가도록 그대로 던짐
            log.warn("❌ 잘못된 요청: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("❌ 게시글 등록 중 오류: {}", e.getMessage(), e);
            throw new RuntimeException("게시글 등록 중 오류 발생", e);
        }
    }

    /**
     * ✅ 게시글 전체 조회
     */
    @Override
    public List<BoardVO> selectAll() {
        log.info("📌 게시글 전체 조회");
        return boardMapper.selectAll();
    }

    /**
     * ✅ 게시글 상세 조회
     */
    @Override
    public BoardVO selectById(int boardId) {
        log.info("📌 게시글 상세 조회 요청: {}", boardId);
        return boardMapper.selectById(boardId);
    }

    /**
     * ✅ 게시글 수정 (이미지 교체 포함)
     */
    @Override
    @Transactional
    public int update(BoardDTO dto, List<MultipartFile> images) {
        try {
            log.info("📌 게시글 수정 요청: {}", dto);
            validateBoardDTO(dto);

            BoardVO existing = boardMapper.selectById(dto.getBoardId());
            if (existing == null) throw new IllegalArgumentException("존재하지 않는 게시글입니다.");

            // 새 이미지가 올라왔을 때만 교체 (없으면 기존 유지)
            String newImageUrl = existing.getImageUrls();
            if (images != null && !images.isEmpty()) {
                newImageUrl = uploadImage(images); // ❗ 형식/확장자 오류 시 IllegalArgumentException 발생
            }

            BoardVO vo = BoardVO.builder()
                    .boardId(dto.getBoardId())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .imageUrls(newImageUrl)
                    .updatedDate(LocalDateTime.now())
                    .build();

            int result = boardMapper.update(vo);
            if (result == 0) throw new RuntimeException("게시글 수정 실패");
            log.info("✅ 게시글 수정 성공: {}", vo);
            return result;

        } catch (IllegalArgumentException e) {
            log.warn("❌ 잘못된 요청: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("❌ 게시글 수정 중 오류: {}", e.getMessage(), e);
            throw new RuntimeException("게시글 수정 중 오류 발생", e);
        }
    }

    /**
     * ✅ 게시글 삭제
     */
    @Override
    @Transactional
    public int delete(int boardId) {
        log.info("📌 게시글 삭제 요청: {}", boardId);
        return boardMapper.delete(boardId);
    }

    /**
     * ✅ 단일 이미지 업로드
     * - 허용 확장자: jpg, jpeg, png, webp, gif
     * - MIME: image/* 만 허용
     * - 잘못된 형식일 경우 IllegalArgumentException 던짐 → 전역 예외 처리기에서 400으로 응답
     */
    private String uploadImage(List<MultipartFile> images) throws IOException {
        if (images == null || images.isEmpty()) return null;

        MultipartFile image = images.get(0); // 단일 이미지 정책
        String originalFilename = image.getOriginalFilename();

        if (originalFilename == null || originalFilename.isBlank()) {
            throw new IllegalArgumentException("이미지 파일 이름이 비어 있습니다.");
        }

        // 확장자 검증
        String lower = originalFilename.toLowerCase();
        int dot = lower.lastIndexOf('.');
        if (dot < 0) {
            throw new IllegalArgumentException("이미지 파일 형식이 아닙니다. 확장자가 없습니다.");
        }
        String ext = lower.substring(dot + 1);
        if (!(ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png") || ext.equals("webp") || ext.equals("gif"))) {
            throw new IllegalArgumentException("이미지 파일만 업로드할 수 있습니다. (jpg, jpeg, png, webp, gif)");
        }

        // MIME 검증
        String contentType = image.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("이미지 파일 형식이 아닙니다. (Content-Type: " + contentType + ")");
        }

        // 업로드 경로 준비
        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists() && dir.mkdirs()) {
            log.info("📂 업로드 디렉토리 생성: {}", dir.getAbsolutePath());
        }

        // 저장
        String filename = UUID.randomUUID() + "_" + originalFilename;
        File dest = new File(uploadDir + filename);
        image.transferTo(dest);
        log.info("📁 이미지 업로드 완료: {}", dest.getAbsolutePath());

        return "/uploads/" + filename;
    }

    /**
     * ✅ 입력값 검증
     */
    private void validateBoardDTO(BoardDTO dto) {
        if (dto == null) throw new IllegalArgumentException("게시글 데이터가 없습니다.");
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty())
            throw new IllegalArgumentException("제목은 필수입니다.");
        if (dto.getContent() == null || dto.getContent().trim().isEmpty())
            throw new IllegalArgumentException("내용은 필수입니다.");
    }
}
