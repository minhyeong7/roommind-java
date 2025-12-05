package com.roomgenius.furniture_recommendation.mapper;

import com.roomgenius.furniture_recommendation.entity.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryVO> selectAllCategories();

    CategoryVO getCategoryById(Integer categoryId);

    String getCategoryName(Integer categoryId);

    int insertCategory(CategoryVO vo);

    int updateCategory(CategoryVO vo);

    int deleteCategory(Integer categoryId);

    // 정렬 업데이트용
    void updateOrder(@Param("categoryId") Integer categoryId,
                     @Param("sortOrder") Integer sortOrder);
}

