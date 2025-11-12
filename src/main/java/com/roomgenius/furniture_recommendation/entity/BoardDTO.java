package com.roomgenius.furniture_recommendation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 게시글 DTO (API 요청/응답용)
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardDTO {
    // ===== 응답 시에만 포함되는 필드 =====
    private Integer boardId;
    private Integer userId;
    private String username;
    private String email;
    private Integer commentCount;
    private Integer likeCount;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // ===== 요청/응답 공통 필드 (Validation 적용) =====
    @NotBlank(message = "제목은 필수입니다")
    @Size(max = 255, message = "제목은 255자를 초과할 수 없습니다")
    private String title;

    @NotBlank(message = "내용은 필수입니다")
    @Size(max = 500, message = "내용은 500자를 초과할 수 없습니다")
    private String content;

    @Size(max = 5, message = "이미지는 최대 5개까지 첨부 가능합니다")
    private List<String> imageUrls;
}