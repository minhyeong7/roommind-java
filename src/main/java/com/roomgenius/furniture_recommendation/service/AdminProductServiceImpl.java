package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.ProductDTO;
import com.roomgenius.furniture_recommendation.entity.ProductVO;
import com.roomgenius.furniture_recommendation.mapper.AdminProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminProductServiceImpl implements AdminProductService {

    private final AdminProductMapper adminProductMapper;

    @Override
    public List<ProductVO> getAllProducts() {
        return adminProductMapper.selectAllProducts();
    }

    @Override
    public List<ProductVO> selectFilteredProducts(Integer categoryId, String keyword, String sort) {
        return adminProductMapper.selectFilteredProducts(categoryId, keyword, sort);
    }

    @Override
    public ProductVO getProductById(Integer id) {
        return adminProductMapper.getProductById(id);
    }

    @Override
    public void addProduct(ProductDTO dto) {
        adminProductMapper.insertProduct(dto);
    }

    @Override
    public void updateProduct(Integer id, ProductDTO dto) {
        dto.setProductId(id);
        adminProductMapper.updateProduct(dto);
    }

    @Override
    public void deleteProduct(Integer id) {
        adminProductMapper.deleteProduct(id);
    }
}
