package com.roomgenius.furniture_recommendation.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileDTO {

    private String uuid;

    private Integer qnaBoardId;
    private Integer productId;
    private Integer communityBoardId;

    private String saveDir;
    private String fileName;
    private Integer fileType;
    private Long fileSize;

    private LocalDateTime createdDate;
}

