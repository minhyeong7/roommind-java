--  카테고리 초기 데이터 삽입
--  major_category: 대분류 - 가구, 디지털
--  middle_category: 중분류 - 소파, 침대 등등
--
--  서버 시작 시 자동으로 기본적인 카테고리들을 생성하기 위함 - smh

-- IGNORE 는 기존 데이터가 있으면 무시
INSERT IGNORE INTO Category (major_category, middle_category)
VALUES
('가구', '소파'),
('가구', '침대'),
('가구', '의자'),
('가구', '식탁'),
('디지털', 'TV'),
('디지털', '냉장고'),
('디지털', '전자레인지');





-- ===========================
-- Product Seed Data
-- ===========================
INSERT IGNORE INTO Product
(category_id, product_name, brand, original_price, sale_price, stock, description)
VALUES
-- 가구 - 소파 (category_id = 1)
(1, '모던 3인용 가죽 소파', '한샘', 890000, 790000, 10, '고급스러운 가죽 소재의 모던 소파'),
(1, '패브릭 컴포트 소파', '이케아', 420000, 380000, 20, '편안한 착석감의 패브릭 소파'),

-- 가구 - 침대 (category_id = 2)
(2, '퀸사이즈 원목 침대', '일룸', 990000, 890000, 7, '튼튼한 원목 프레임 침대'),
(2, '모던 저상형 침대', '까사미아', 590000, 530000, 12, '안정감 있는 저상형 디자인'),

-- 가구 - 의자 (category_id = 3)
(3, '인체공학 메쉬 의자', '시디즈', 240000, 210000, 25, '장시간 작업에 적합한 메쉬 의자'),
(3, '고급 PU 가죽 의자', '한샘', 180000, 160000, 15, '편안한 착석감 제공'),

-- 가구 - 식탁 (category_id = 4)
(4, '4인용 원목 식탁', '리바트', 350000, 299000, 10, '내추럴 원목 식탁'),
(4, '모던 유리 식탁', '까사미아', 280000, 249000, 8, '깔끔한 유리 상판 디자인'),

-- 디지털 - TV (category_id = 5)
(5, '55인치 UHD 스마트 TV', '삼성', 750000, 680000, 20, '4K UHD 해상도의 스마트 TV'),
(5, '65인치 QLED TV', 'LG', 1200000, 1090000, 12, '선명한 컬러의 QLED 디스플레이'),

-- 디지털 - 냉장고 (category_id = 6)
(6, '양문형 850L 냉장고', '삼성', 1450000, 1320000, 6, '대용량 양문형 냉장고'),
(6, '4도어 프리미엄 냉장고', 'LG', 1580000, 1470000, 3, '정품 인버터 컴프레서 탑재');



-- ===========================
-- File Seed Data
-- ===========================
-- ===========================
-- File Seed Data
-- ===========================
INSERT IGNORE INTO File
(uuid, product_id, save_dir, file_name, file_type, file_size)
VALUES
(UUID(), 1, 'uploads/product/seed/sofa', 'sofa01.avif', 0, 0),
(UUID(), 2, 'uploads/product/seed/sofa', 'sofa02.avif', 0, 0),

(UUID(), 3, 'uploads/product/seed/bed', 'bed01.avif', 0, 0),
(UUID(), 4, 'uploads/product/seed/bed', 'bed02.avif', 0, 0),

(UUID(), 5, 'uploads/product/seed/chair', 'chair01.avif', 0, 0),
(UUID(), 6, 'uploads/product/seed/chair', 'chair02.avif', 0, 0),

(UUID(), 7, 'uploads/product/seed/table', 'table01.avif', 0, 0),
(UUID(), 8, 'uploads/product/seed/table', 'table02.avif', 0, 0),

(UUID(), 9, 'uploads/product/seed/tv', 'tv01.avif', 0, 0),
(UUID(), 10, 'uploads/product/seed/tv', 'tv02.avif', 0, 0),

(UUID(), 11, 'uploads/product/seed/fridge', 'fridge01.avif', 0, 0),
(UUID(), 12, 'uploads/product/seed/fridge', 'fridge02.avif', 0, 0);



