package com.roomgenius.furniture_recommendation.mapper;


import com.roomgenius.furniture_recommendation.entity.BoardVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insert(BoardVO bvo);


}
