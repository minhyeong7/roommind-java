package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.entity.ProductDTO;
import com.roomgenius.furniture_recommendation.entity.ProductVO;
import com.roomgenius.furniture_recommendation.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/products")
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

    /** 전체 조회 */
    @GetMapping
    public List<ProductVO> getAll() {
        return adminProductService.getAllProducts();
    }

    /** 필터 조회 */
    @GetMapping("/filter")
    public List<ProductVO> filter(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "latest") String sort
    ) {
        return adminProductService.selectFilteredProducts(categoryId, keyword, sort);
    }

    /** 단일 조회 */
    @GetMapping("/{id}")
    public ProductVO getOne(@PathVariable Integer id) {
        return adminProductService.getProductById(id);
    }

    /** 등록 */
    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ProductDTO dto) {
        adminProductService.addProduct(dto);
        return ResponseEntity.ok("created");
    }

    /** 수정 */
    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Integer id, @RequestBody ProductDTO dto
    ) {
        adminProductService.updateProduct(id, dto);
        return ResponseEntity.ok("updated");
    }

    /** 삭제 */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        adminProductService.deleteProduct(id);
        return ResponseEntity.ok("deleted");
    }
}
