package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.ProductDTO;
import com.roomgenius.furniture_recommendation.entity.ProductVO;

import java.util.List;

public interface AdminProductService {

    List<ProductVO> getAllProducts();

    List<ProductVO> selectFilteredProducts(Integer categoryId, String keyword, String sort);

    ProductVO getProductById(Integer id);

    void addProduct(ProductDTO dto);

    void updateProduct(Integer id, ProductDTO dto);

    void deleteProduct(Integer id);
}
