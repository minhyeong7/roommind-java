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
('디지털', '전자레인지'),
('가구', '거울'),
('가구', '화장대'),
('가구', '서랍'),
('가구', '스탠드'),
('패브릭', '침구(이불세트)'),
('크리스마스', '트리');


-- ===========================
-- Product Seed Data
-- ===========================
INSERT IGNORE INTO Product
(category_id, product_name, brand, original_price, sale_price, stock, description)
VALUES
-- 가구 - 소파 (category_id = 1)
(1, '슬림 4인 카우치 소파', '캄포구스', 720000, 659000, 12, '슬림한 디자인의 4인 카우치형 패브릭 소파'),
(1, '툰 가죽 소파 (1~3인용)', '툰', 580000, 529000, 15, '블랙 인테리어에 어울리는 가죽 소파'),
(1, '누베스 아쿠아텍스 패브릭 소파 (2~3인용)', '누베스', 390000, 349000, 18, '아쿠아텍스 소재의 편안한 패브릭 소파'),
(1, '카페 패브릭 2인 접이식 소파베드', '카페', 310000, 279000, 14, '2인용 접이식 패브릭 소파베드'),
(1, '매스 아쿠아텍스 2인 패브릭 소파', '매스', 290000, 259000, 20, '아쿠아텍스 소재의 2인 패브릭 소파'),
(1, '눕 데일리 구스 아쿠아텍스 4인 모듈 소파', '한샘', 890000, 820000, 7, '구스 충전재의 4인용 모듈형 소파'),
(1, '라운지 구스 아쿠아텍스 4인 모듈 소파', '라운지', 650000, 599000, 10, '구스 패딩의 모듈형 4인 소파'),
(1, '앤고 아쿠아텍스 2인 패브릭 소파', '앤고', 280000, 249000, 19, '아쿠아텍스 소재의 2인 패브릭 소파'),
(1, '포레스트 4인 기능성 워셔블 모듈 소파', '포레스트', 690000, 629000, 11, '워셔블 기능의 4인 모듈 패브릭 소파'),
(1, '모니 패브릭 1인 좌식 소파', '모니', 140000, 119000, 25, '각도 조절 가능한 1인 좌식 소파'),


-- 가구 - 침대 (category_id = 2)
(2, '어텀 시즌2 원목 침대 SS/Q', '어텀', 420000, 379000, 13, 'SS/Q 선택 가능한 원목 프레임 침대'),
(2, '오름 평상형 원목 침대 SS/Q/K', '오름', 450000, 409000, 11, '2컬러 평상형 원목 침대'),
(2, '플러피 조야 패브릭 침대 SS/Q', '플러피', 320000, 289000, 17, '무헤드/헤드 선택 가능한 패브릭 침대'),
(2, '비안 아쿠아텍스 패브릭 침대 SS/Q/K', '비안', 390000, 349000, 14, '아쿠아텍스 소재 매트리스 선택형 침대'),
(2, '뷰티레스트 시트러스 라지킹 침대', '뷰티레스트', 890000, 829000, 6, '라지킹 사이즈 프리미엄 침대'),
(2, '밀리 일반형 침대 SS/Q', '밀리', 360000, 329000, 12, '매트리스 포함 일반형 침대'),
(2, '뷰티레스트 자스민 퀸 침대 + 협탁', '뷰티레스트', 720000, 669000, 7, '자스민 원단 퀸 프레임 + 협탁 세트'),
(2, '몬드 호텔 패브릭 침대 SS/Q/K', '몬드', 580000, 529000, 10, '호텔 감성 패브릭 침대 (매트 포함)'),
(2, '클로즈 침대 Q/K + 라텍스탑 매트리스', '클로즈', 640000, 599000, 9, '노뜨 라텍스탑 매트리스 포함 세트'),
(2, '에디트 평상형 침대 SS/Q/K', '에디트', 330000, 299000, 20, '평상형 프레임 매트 포함'),


-- 가구 - 의자 (category_id = 3)
(3, '뮤즈 팔걸이 메쉬 컴퓨터 의자', '뮤즈', 89000, 79000, 18, '팔걸이 적용된 편한 메쉬 사무용 의자'),
(3, '페블 디자인 식탁 의자', '페블', 59000, 52000, 20, '패브릭/가죽 선택 가능한 미드센츄리 디자인'),
(3, 'OLIVER 스툴', 'OLIVER', 39000, 35000, 25, '심플한 디자인의 보조 스툴'),
(3, '아크 디자인 스툴', '아크', 45000, 39900, 22, '3컬러 인테리어 디자인 스툴'),
(3, '레이븐 원목 이지클린 식탁 의자', '레이븐', 129000, 115000, 14, '원목 + 이지클린 쿠션 구조의 식탁 의자'),
(3, '코지 우드 러그 원목 식탁 의자', '코지', 110000, 99000, 15, '우드 + 스틸 조합의 디자인 체어'),
(3, '듀이 플라스틱 식탁 의자', '듀이', 59000, 52000, 19, '카페 감성 플라스틱 디자인 의자'),
(3, '뮤즈 헤드형 메쉬 컴퓨터 의자', '뮤즈', 119000, 99000, 12, '헤드레스트 포함된 편안한 메쉬 의자'),
(3, '포니 패브릭/가죽 디자인 식탁 의자', '포니', 79000, 69000, 21, '미드센츄리 패브릭 가죽 디자인'),
(3, '메탈 인테리어 스툴', '메탈', 45000, 39900, 24, '부클레 디자인의 보조 인테리어 스툴'),


-- 가구 - 식탁 (category_id = 4)
(4, '코넬 이지 1600 데스크 세트', '코넬', 159000, 145000, 18, '1600 사이즈 책상 + 책장 일체형 데스크'),
(4, '오테카 원목 책상 1200', '오테카', 139000, 125000, 20, '누적판매 3만건 원목 책상'),
(4, '유닛 1200 코너 데스크 세트', '유닛', 189000, 169000, 15, '코너형 컴퓨터 책상 + 책장 세트'),
(4, '듀플 리버서블 오피스 데스크', '듀플', 179000, 159000, 14, '리버서블 구조의 화이트 오피스 책상'),
(4, '노트르 화이트 사무용 책상', '노트르', 129000, 115000, 19, '화이트 톤 사무용 컴퓨터 책상'),
(4, '원목 전동 모션데스크', '전동모션', 299000, 279000, 12, '5분 조립 가능한 원목 모션 데스크'),
(4, '제로데스크 에보 컴퓨터 책상', '제로데스크', 159000, 145000, 17, '홈오피스용 에보 컴퓨터 책상'),
(4, '라운드 스퀘어 홈오피스 책상', '라운드스퀘어', 139000, 125000, 16, 'E0 자재 라운드형 데스크'),
(4, '게이밍/1인용/2인용 컴퓨터 책상', '게이밍', 99000, 89000, 23, '1~2인 구성 가능한 게이밍 책상'),
(4, '에어 E0 컴퓨터 데스크 800~1600', '에어', 109000, 98000, 22, '멀티탭 덕트 증정 E0 등급 데스크'),


-- 디지털 - TV (category_id = 5)
(5, '화이트 43인치 4K 스마트TV', '화이트에디션', 520000, 469000, 15, '43인치 4K UHD 화이트 스마트 TV'),
(5, '화이트 50인치 QLED 스마트TV', '화이트에디션', 670000, 599000, 12, '50인치 QLED 화이트 스마트 TV'),
(5, '화이트 43인치 QLED 스마트TV', '화이트에디션', 640000, 575000, 20, '43인치 QLED 화이트 스마트 TV'),
(5, '무빙큐빅스 화이트 32인치 HD TV', '무빙큐빅스', 410000, 369000, 14, '32인치 HD 화이트 무빙큐빅스 TV'),
(5, '삼성 65인치 4K 스마트TV (리퍼)', '삼성', 890000, 759000, 8, '65인치 4K UHD 리퍼 삼성 스마트 TV'),
(5, 'LG 43인치 UHD TV', 'LG', 620000, 549000, 10, '43인치 LG UHD TV'),
(5, '무빙큐빅스 화이트 40인치 FHD TV', '무빙큐빅스', 480000, 429000, 18, '40인치 FHD 무빙큐빅스 스마트 TV'),
(5, '삼성 55인치 4K 스마트TV (리퍼)', '삼성', 760000, 689000, 9, '55인치 4K UHD 리퍼 삼성 TV'),
(5, '대형 이동식 TV 스탠드 75인치 호환', '삼탠바이미', 290000, 255000, 25, '75인치까지 호환되는 이동식 TV 스탠드'),
(5, '화이트 55인치 QLED 스마트TV', '화이트에디션', 720000, 659000, 11, '55인치 QLED 화이트 스마트 TV'),


-- 디지털 - 냉장고 (category_id = 6)
(6, 'LG 모던엣지 344L 오브제 냉장고', 'LG', 890000, 829000, 12, '상냉장 하냉동 구조의 344L 오브제 냉장고'),
(6, '컨버터블 321 세트 냉장고 패키지', 'XYZ', 2380000, 2250000, 5, '3모듈 조합형 컨버터블 세트 냉장고'),
(6, 'LG 디오스 AI 오브제 836L 냉장고', 'LG', 1190000, 1120000, 8, '디오스 AI 기반 오브제 냉장고'),
(6, '오브제 컨버터블 김치냉장고 321L', '오브제', 810000, 759000, 11, '컨버터블 패키지 김치냉장고'),
(6, '레트로 미니 냉장고 121L', '레트로', 189000, 169000, 22, '감성 디자인의 121L 미니 냉장고'),
(6, '샤인 멀티냉각 507L 일반 냉장고', '샤인', 610000, 569000, 10, '멀티냉각 시스템 507L 일반 냉장고'),
(6, '모드비 312L 피트인 콤비냉장고', '모드비', 540000, 499000, 16, '4컬러 파스텔 피트인 콤비냉장고'),
(6, '스탠드형 슈퍼슬림 김치냉장고 80L', 'ARK', 330000, 299000, 17, '스탠드형 슈퍼슬림 80L 김치냉장고'),
(6, '레트로 85L 미니 냉장고', '레트로', 159000, 139000, 23, '2도어 소형 미니 냉장고'),
(6, '155L 스탠드 냉동고', 'CFZ', 290000, 259000, 18, '간접 냉각 시스템 155L 냉동고'),


-- 디지털 - 전자레인지 (category_id = 7)
(7, '20L 무회전 전자레인지', 'CMW', 109000, 89000, 18, '무회전 설계의 20L 전자레인지'),
(7, '쿠첸 클래식 레트로 전자레인지', '쿠첸', 139000, 129000, 15, '감성 디자인의 레트로 전자레인지'),
(7, '23L 스마트 인버터 전자레인지', 'LG', 159000, 149000, 20, '23L 용량의 스마트 인버터 전자레인지'),
(7, '23L 오브제 전자레인지', 'LG 오브제', 179000, 169000, 14, '오브제컬렉션 디자인 23L 전자레인지'),
(7, '20L 레트로 전자레인지', 'MC', 119000, 109000, 22, '미니 사이즈의 20L 레트로 전자레인지'),
(7, '20L 버튼식 전자레인지', 'RMW', 129000, 119000, 17, '고급형 버튼식 20L 전자레인지'),
(7, '20L 레트로 버튼식 전자레인지', 'MM', 125000, 115000, 19, '원룸에 적합한 미니 레트로 버튼식 모델'),
(7, '20L 전자레인지 프로 모델', 'JRK', 140000, 110000, 16, '20L 용량의 프로 전자레인지'),
(7, '23L 다이얼 전자레인지', 'CMW', 115000, 81000, 21, '대용량 23L 다이얼 방식 전자레인지'),
(7, '23L 비스포크 전자레인지', '삼성', 199000, 179000, 12, '비스포크 디자인의 23L 전자레인지'),


-- 가구 - 전신거울 (category_id = 8)
(8, '3사이즈 전신거울', '미러즈', 79000, 69000, 20, '300·400·600 사이즈 선택 가능한 심플 전신거울'),
(8, '노프레임 미드센추리 전신거울', '포니', 119000, 99000, 14, '비산방지 처리된 알루미늄 프레임 전신거울'),
(8, '1200 와이드 이동식 전신거울', '올타', 159000, 145000, 12, '이동식 스탠드 구조의 1200 와이드 거울'),
(8, '웨이브 와이드 전신거울', 'e스마트', 139000, 129000, 18, '트렌디한 물결 웨이브 디자인의 대형 전신거울'),
(8, '아치형 노프레임 전신거울', '어반', 129000, 115000, 17, '300~800mm 선택 가능한 아치형 전신거울'),
(8, '도브 전신거울 수납 화장대', '도브', 129000, 99900, 16, '틈새 수납 가능한 화장대 겸용 전신거울'),
(8, '시그니쳐 거치형 전신거울', '시그니쳐', 110000, 99000, 15, '3컬러 구성의 스탠드형 전신거울'),
(8, '페이트 아치형 스탠드 거울', '페이트', 89000, 52155, 22, '600·700·800 사이즈 미드센추리 아치형 전신거울'),
(8, '대형 와이드 스탠드 전신거울', '와이드미러', 159000, 139000, 14, '700/1000 선택 가능한 대형 와이드 전신거울'),
(8, '강화 안전 전신거울', '세이프미러', 79000, 69000, 25, '비산·파손 방지 강화 안전 전신거울'),


-- 가구 - 화장대 (category_id = 9)
(9, '루나 600 수납 화장대', '루나', 129000, 115000, 16, '3컬러 선택 가능한 600 사이즈 수납 화장대'),
(9, '스완A 원목 콘솔 화장대', '스완A', 189000, 169000, 12, '거울·스툴 옵션 선택 가능한 원목 콘솔 화장대'),
(9, '오블릭 미니 수납 화장대 900', '오블릭', 159000, 139000, 18, '국내 제작 900size 서랍 수납 화장대'),
(9, '오로르 템바보드 화장대 세트', '오로르', 179000, 159000, 14, 'E0 템바보드 구조의 거울 세트 화장대'),
(9, '코코2 확장형 수납 화장대', '코코', 149000, 135000, 20, '거울 포함 확장형 구조 수납 화장대'),
(9, '에스티 하이그로시 화장대', '에스티', 159000, 145000, 17, '가로폭 조절 가능한 하이그로시 화장대'),
(9, '엔틱 원목 수납 화장대', '엔틱', 219000, 199000, 11, '수납장/뷰로/거울/스툴 구성 선택 가능'),
(9, '모던 글래스 미니 화장대 600', '모던글래스', 139000, 125000, 19, '600 사이즈의 유리포인트 미니 화장대'),
(9, '클래식 라운드 원목 화장대', '클래식', 189000, 169000, 13, '원목 라운드 거울 포함 선반·수납 화장대'),
(9, '스완 와이드 수납 화장대', '스완', 99000, 74900, 22, '와이드 거울 포함된 원목 수납 화장대'),


-- 가구 - 서랍장 (category_id = 10)
(10, '레이어 모듈 철제 서랍장', '레이어', 129000, 115000, 18, '400~1200 선택 가능한 미드센츄리 철제 서랍장'),
(10, '피트 빈티지 캐비넷 서랍장', '피트', 159000, 145000, 14, '2~5단 구성의 빈티지 스타일 캐비넷'),
(10, '토리 와이드 3단 서랍장', '토리', 139000, 125000, 17, '800/1200 선택 가능한 와이드형 서랍장'),
(10, '피하 4단 서랍장', '피하', 119000, 105000, 20, '심플한 디자인의 4단 기본형 서랍장'),
(10, '모라 템바 와이드 서랍장', '모라', 179000, 165000, 12, '3/5단 선택 가능한 템바보드 와이드 서랍장'),
(10, '헤이즐 다단 서랍장', '헤이즐', 149000, 135000, 16, '3단/6단/7단 구성의 기본형 서랍장'),
(10, '맥시멈마카롱 속깊은 와이드 서랍장', '마카롱', 189000, 169000, 10, '600·800 사이즈 깊은 수납 와이드 서랍장'),
(10, '나오미 7단 와이드 서랍장', '나오미', 169000, 149000, 13, '6colors 구성의 대형 와이드 서랍장'),
(10, '메가 칸칸이 5단 서랍장', '메가', 159000, 139000, 18, '5컬러 선택 가능한 5단 칸칸이 서랍장'),
(10, '프롬 3단 와이드 서랍장', '프롬', 139000, 125000, 15, '800/1200 선택 가능한 E0 등급 서랍장'),


-- 가구 - 스탠드 조명 (category_id = 11)
(11, '캐슬 장스탠드 조명', '캐슬', 129000, 113400, 18, '쿠폰 적용 가능한 미니멀 장스탠드 조명'),
(11, '스프링 플로어 인테리어 스탠드', '스프링', 89000, 79000, 20, '6colors 구성의 플로어/식물재배 스탠드'),
(11, '더블레이어 120 장스탠드', '더블레이어', 159000, 149000, 14, '3colors 선택 가능한 120cm 장스탠드'),
(11, '머쉬룸 장스탠드 조명', '머쉬룸', 99000, 89000, 16, '국내 제작 7colors 전구 증정 스탠드 조명'),
(11, '아르코 스틸 실버 장스탠드', '아르코', 139000, 125000, 13, '활장램프 타입의 스틸 실버 장스탠드'),
(11, '블랑드문 아크릴 장스탠드', '블랑드문', 159000, 145000, 17, '투명 아크릴 재질의 5colors 스탠드 조명'),
(11, '레이어 플로어 램프', '레이어', 119000, 105000, 20, '인테리어용 모던 플로어 스탠드 램프'),
(11, '미니아일랜드 장스탠드', '미니아일랜드', 59000, 38610, 22, 'LED 전구 증정 미니멀 장스탠드 조명'),
(11, '코니 아일랜드 장스탠드', '코니', 52000, 33210, 25, '3단 조립형 장스탠드 조명'),
(11, '알렉스 장스탠드', '알렉스', 99000, 89000, 15, '2colors 구성의 베이직 장스탠드'),


-- 가구 - 차렵이불 (category_id = 12)
(12, '카스테라 워싱 옥수수솜 차렵이불세트', '카스테라', 129000, 115000, 20, '사계절/한파용 극세사 워싱 차렵이불세트'),
(12, '호텔침구 클린코튼 옥수수솜 이불세트', '클린코튼', 139000, 125000, 18, '사계절 및 겨울용 고밀도 60수 호텔식 이불'),
(12, '유어메이트 항균 차렵이불 풀세트', '유어메이트', 119000, 105000, 22, '항균 소재의 겨울/사계절 15컬러 이불'),
(12, '빌리호텔 사계절 극세사 차렵이불세트', '빌리호텔', 109000, 98000, 16, '8colors 먼지없는 극세사 차렵이불'),
(12, '프렌치 스트라이프 옥수수솜 이불 S/SS', '프렌치', 99000, 89000, 14, '사계절용 클래식 프렌치 스트라이프 디자인'),
(12, '카스테라 스트라이프 한파용 차렵이불', '카스테라', 149000, 135000, 13, '워싱 스트라이프 한파용 극세사 차렵이불'),
(12, '수플레 겨울 극세사 옥수수솜 이불세트', '수플레', 139000, 125000, 17, '11컬러 구성의 겨울용 극세사 차렵이불'),
(12, '돈워리 알러지케어 유칼립투스솜 이불', '돈워리', 119000, 105000, 21, '극세사·알러지케어 사계절 이불세트'),
(12, '가드M2 사계절 극세사 차렵이불세트', '가드M2', 109000, 95000, 19, '12color 구성의 항알러지 극세사 이불세트'),
(12, '도즈 60수 순면 사계절 차렵이불세트', '도즈', 129000, 115000, 15, '간절기/사계절용 60수 순면 차렵이불'),


-- 크리스마스 트리 (category_id = 13)
(13, '하이엔드 피시본 투톤 무장식 대형 트리', '피시본', 159000, 145000, 20, '120~210cm 투톤 컬러의 고급 무장식 크리스마스 트리'),
(13, '클래식 LED 자작나무 트리', '클래식', 89000, 79000, 22, '60~180cm LED 무드등 일체형 자작나무 트리'),
(13, '화이트 스케치 스노우 PE 전나무 트리', '스케치', 179000, 165000, 18, '120~210cm 대형 화이트 스노우 무장식 트리'),
(13, '팝업트리 로얄 원터치 접이식 트리 풀세트', '팝업트리', 119000, 105000, 25, '2size 원터치 업다운 크리스마스 트리 풀세트'),
(13, '팝업트리 오리지널 캐슬 원터치 트리 풀세트', '팝업트리', 109000, 98000, 20, '2size 업다운 원터치 크리스마스 트리 풀세트'),
(13, '올인원 원터치 크리스마스 트리', '올인원', 129000, 115000, 19, '10초 설치/해체 가능한 원터치 트리'),
(13, '트리 장식 풀세트 6종', '장식세트', 99000, 89000, 17, '1.2~1.5M 구성의 크리스마스트리 장식 풀세트'),
(13, '하이엔드 피시본 그린 무장식 대형 트리', '피시본', 159000, 145000, 15, '120~210cm 고급 피시본 그린 무장식 트리'),
(13, 'LED탑별 장식 풀세트 트리', 'LED트리', 139000, 125000, 21, '1.3~1.9m LED + 장식 + 탑별 올인원 풀세트'),
(13, '원터치 블랙트리 180cm 풀세트', '블랙트리', 119000, 105000, 23, '접이식 5초 완성 180cm 블랙트리 + 보관백 포함');



-- ===========================
-- File Seed Data
-- ===========================

-- 소파
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa01.avif', 0, 0
FROM Product p WHERE p.product_name = '슬림 4인 카우치 소파';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa02.avif', 0, 0
FROM Product p WHERE p.product_name = '툰 가죽 소파 (1~3인용)';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa03.avif', 0, 0
FROM Product p WHERE p.product_name = '누베스 아쿠아텍스 패브릭 소파 (2~3인용)';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa04.avif', 0, 0
FROM Product p WHERE p.product_name = '카페 패브릭 2인 접이식 소파베드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa05.avif', 0, 0
FROM Product p WHERE p.product_name = '매스 아쿠아텍스 2인 패브릭 소파';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa06.avif', 0, 0
FROM Product p WHERE p.product_name = '눕 데일리 구스 아쿠아텍스 4인 모듈 소파';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa07.avif', 0, 0
FROM Product p WHERE p.product_name = '라운지 구스 아쿠아텍스 4인 모듈 소파';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa08.avif', 0, 0
FROM Product p WHERE p.product_name = '앤고 아쿠아텍스 2인 패브릭 소파';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa09.avif', 0, 0
FROM Product p WHERE p.product_name = '포레스트 4인 기능성 워셔블 모듈 소파';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/sofa', 'sofa10.avif', 0, 0
FROM Product p WHERE p.product_name = '모니 패브릭 1인 좌식 소파';



-- 침대
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed01.avif', 0, 0
FROM Product p WHERE p.product_name = '어텀 시즌2 원목 침대 SS/Q';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed02.avif', 0, 0
FROM Product p WHERE p.product_name = '오름 평상형 원목 침대 SS/Q/K';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed03.avif', 0, 0
FROM Product p WHERE p.product_name = '플러피 조야 패브릭 침대 SS/Q';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed04.avif', 0, 0
FROM Product p WHERE p.product_name = '비안 아쿠아텍스 패브릭 침대 SS/Q/K';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed05.avif', 0, 0
FROM Product p WHERE p.product_name = '뷰티레스트 시트러스 라지킹 침대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed06.avif', 0, 0
FROM Product p WHERE p.product_name = '밀리 일반형 침대 SS/Q';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed07.avif', 0, 0
FROM Product p WHERE p.product_name = '뷰티레스트 자스민 퀸 침대 + 협탁';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed08.avif', 0, 0
FROM Product p WHERE p.product_name = '몬드 호텔 패브릭 침대 SS/Q/K';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed09.avif', 0, 0
FROM Product p WHERE p.product_name = '클로즈 침대 Q/K + 라텍스탑 매트리스';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/bed', 'bed10.avif', 0, 0
FROM Product p WHERE p.product_name = '에디트 평상형 침대 SS/Q/K';




-- 의자
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair01.avif', 0, 0
FROM Product p WHERE p.product_name = '뮤즈 팔걸이 메쉬 컴퓨터 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair02.avif', 0, 0
FROM Product p WHERE p.product_name = '페블 디자인 식탁 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair03.avif', 0, 0
FROM Product p WHERE p.product_name = 'OLIVER 스툴';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair04.avif', 0, 0
FROM Product p WHERE p.product_name = '아크 디자인 스툴';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair05.avif', 0, 0
FROM Product p WHERE p.product_name = '레이븐 원목 이지클린 식탁 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair06.avif', 0, 0
FROM Product p WHERE p.product_name = '코지 우드 러그 원목 식탁 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair07.avif', 0, 0
FROM Product p WHERE p.product_name = '듀이 플라스틱 식탁 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair08.avif', 0, 0
FROM Product p WHERE p.product_name = '뮤즈 헤드형 메쉬 컴퓨터 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair09.avif', 0, 0
FROM Product p WHERE p.product_name = '포니 패브릭/가죽 디자인 식탁 의자';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/chair', 'chair10.avif', 0, 0
FROM Product p WHERE p.product_name = '메탈 인테리어 스툴';



-- 식탁
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table01.avif', 0, 0
FROM Product p WHERE p.product_name = '코넬 이지 1600 데스크 세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table02.avif', 0, 0
FROM Product p WHERE p.product_name = '오테카 원목 책상 1200';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table03.avif', 0, 0
FROM Product p WHERE p.product_name = '유닛 1200 코너 데스크 세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table04.avif', 0, 0
FROM Product p WHERE p.product_name = '듀플 리버서블 오피스 데스크';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table05.avif', 0, 0
FROM Product p WHERE p.product_name = '노트르 화이트 사무용 책상';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table06.avif', 0, 0
FROM Product p WHERE p.product_name = '원목 전동 모션데스크';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table07.avif', 0, 0
FROM Product p WHERE p.product_name = '제로데스크 에보 컴퓨터 책상';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table08.avif', 0, 0
FROM Product p WHERE p.product_name = '라운드 스퀘어 홈오피스 책상';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table09.avif', 0, 0
FROM Product p WHERE p.product_name = '게이밍/1인용/2인용 컴퓨터 책상';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/table', 'table10.avif', 0, 0
FROM Product p WHERE p.product_name = '에어 E0 컴퓨터 데스크 800~1600';



-- TV
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv01.avif', 0, 0
FROM Product p WHERE p.product_name = '화이트 43인치 4K 스마트TV';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv02.avif', 0, 0
FROM Product p WHERE p.product_name = '화이트 50인치 QLED 스마트TV';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv03.avif', 0, 0
FROM Product p WHERE p.product_name = '화이트 43인치 QLED 스마트TV';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv04.avif', 0, 0
FROM Product p WHERE p.product_name = '무빙큐빅스 화이트 32인치 HD TV';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv05.avif', 0, 0
FROM Product p WHERE p.product_name = '삼성 65인치 4K 스마트TV (리퍼)';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv06.avif', 0, 0
FROM Product p WHERE p.product_name = 'LG 43인치 UHD TV';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv07.avif', 0, 0
FROM Product p WHERE p.product_name = '무빙큐빅스 화이트 40인치 FHD TV';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv08.avif', 0, 0
FROM Product p WHERE p.product_name = '삼성 55인치 4K 스마트TV (리퍼)';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv09.avif', 0, 0
FROM Product p WHERE p.product_name = '대형 이동식 TV 스탠드 75인치 호환';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tv', 'tv10.avif', 0, 0
FROM Product p WHERE p.product_name = '화이트 55인치 QLED 스마트TV';



-- 냉장고
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge01.avif', 0, 0
FROM Product p WHERE p.product_name = 'LG 모던엣지 344L 오브제 냉장고';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge02.avif', 0, 0
FROM Product p WHERE p.product_name = '컨버터블 321 세트 냉장고 패키지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge03.avif', 0, 0
FROM Product p WHERE p.product_name = 'LG 디오스 AI 오브제 836L 냉장고';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge04.avif', 0, 0
FROM Product p WHERE p.product_name = '오브제 컨버터블 김치냉장고 321L';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge05.avif', 0, 0
FROM Product p WHERE p.product_name = '레트로 미니 냉장고 121L';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge06.avif', 0, 0
FROM Product p WHERE p.product_name = '샤인 멀티냉각 507L 일반 냉장고';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge07.avif', 0, 0
FROM Product p WHERE p.product_name = '모드비 312L 피트인 콤비냉장고';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge08.avif', 0, 0
FROM Product p WHERE p.product_name = '스탠드형 슈퍼슬림 김치냉장고 80L';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge09.avif', 0, 0
FROM Product p WHERE p.product_name = '레트로 85L 미니 냉장고';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/fridge', 'fridge10.avif', 0, 0
FROM Product p WHERE p.product_name = '155L 스탠드 냉동고';


-- ===== 카테고리 7 : 전자레인지 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range01.avif', 0, 0
FROM Product p WHERE p.product_name = '20L 무회전 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range02.avif', 0, 0
FROM Product p WHERE p.product_name = '쿠첸 클래식 레트로 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range03.avif', 0, 0
FROM Product p WHERE p.product_name = '23L 스마트 인버터 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range04.avif', 0, 0
FROM Product p WHERE p.product_name = '23L 오브제 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range05.avif', 0, 0
FROM Product p WHERE p.product_name = '20L 레트로 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range06.avif', 0, 0
FROM Product p WHERE p.product_name = '20L 버튼식 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range07.avif', 0, 0
FROM Product p WHERE p.product_name = '20L 레트로 버튼식 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range08.avif', 0, 0
FROM Product p WHERE p.product_name = '20L 전자레인지 프로 모델';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range09.avif', 0, 0
FROM Product p WHERE p.product_name = '23L 다이얼 전자레인지';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/range', 'range10.avif', 0, 0
FROM Product p WHERE p.product_name = '23L 비스포크 전자레인지';



-- ===== 카테고리 8 : 거울 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror01.avif', 0, 0
FROM Product p WHERE p.product_name = '3사이즈 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror02.avif', 0, 0
FROM Product p WHERE p.product_name = '노프레임 미드센추리 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror03.avif', 0, 0
FROM Product p WHERE p.product_name = '1200 와이드 이동식 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror04.avif', 0, 0
FROM Product p WHERE p.product_name = '웨이브 와이드 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror05.avif', 0, 0
FROM Product p WHERE p.product_name = '아치형 노프레임 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror06.avif', 0, 0
FROM Product p WHERE p.product_name = '도브 전신거울 수납 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror07.avif', 0, 0
FROM Product p WHERE p.product_name = '시그니쳐 거치형 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror08.avif', 0, 0
FROM Product p WHERE p.product_name = '페이트 아치형 스탠드 거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror09.avif', 0, 0
FROM Product p WHERE p.product_name = '대형 와이드 스탠드 전신거울';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/mirror', 'mirror10.avif', 0, 0
FROM Product p WHERE p.product_name = '강화 안전 전신거울';




-- ===== 카테고리 9 : 화장대 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd01.avif', 0, 0
FROM Product p WHERE p.product_name = '루나 600 수납 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd02.avif', 0, 0
FROM Product p WHERE p.product_name = '스완A 원목 콘솔 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd03.avif', 0, 0
FROM Product p WHERE p.product_name = '오블릭 미니 수납 화장대 900';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd04.avif', 0, 0
FROM Product p WHERE p.product_name = '오로르 템바보드 화장대 세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd05.avif', 0, 0
FROM Product p WHERE p.product_name = '코코2 확장형 수납 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd06.avif', 0, 0
FROM Product p WHERE p.product_name = '에스티 하이그로시 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd07.avif', 0, 0
FROM Product p WHERE p.product_name = '엔틱 원목 수납 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd08.avif', 0, 0
FROM Product p WHERE p.product_name = '모던 글래스 미니 화장대 600';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd09.avif', 0, 0
FROM Product p WHERE p.product_name = '클래식 라운드 원목 화장대';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/hjd', 'hjd10.avif', 0, 0
FROM Product p WHERE p.product_name = '스완 와이드 수납 화장대';


-- ===== 카테고리 10 : 서랍장 File 매핑 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer01.avif', 0, 0
FROM Product p WHERE p.product_name = '레이어 모듈 철제 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer02.avif', 0, 0
FROM Product p WHERE p.product_name = '피트 빈티지 캐비넷 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer03.avif', 0, 0
FROM Product p WHERE p.product_name = '토리 와이드 3단 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer04.avif', 0, 0
FROM Product p WHERE p.product_name = '피하 4단 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer05.avif', 0, 0
FROM Product p WHERE p.product_name = '모라 템바 와이드 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer06.avif', 0, 0
FROM Product p WHERE p.product_name = '헤이즐 다단 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer07.avif', 0, 0
FROM Product p WHERE p.product_name = '맥시멈마카롱 속깊은 와이드 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer08.avif', 0, 0
FROM Product p WHERE p.product_name = '나오미 7단 와이드 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer09.avif', 0, 0
FROM Product p WHERE p.product_name = '메가 칸칸이 5단 서랍장';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/drawer', 'drawer10.avif', 0, 0
FROM Product p WHERE p.product_name = '프롬 3단 와이드 서랍장';


-- ===== 카테고리 11 : 스탠드 조명 File 매핑 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand01.avif', 0, 0
FROM Product p WHERE p.product_name = '캐슬 장스탠드 조명';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand02.avif', 0, 0
FROM Product p WHERE p.product_name = '스프링 플로어 인테리어 스탠드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand03.avif', 0, 0
FROM Product p WHERE p.product_name = '더블레이어 120 장스탠드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand04.avif', 0, 0
FROM Product p WHERE p.product_name = '머쉬룸 장스탠드 조명';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand05.avif', 0, 0
FROM Product p WHERE p.product_name = '아르코 스틸 실버 장스탠드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand06.avif', 0, 0
FROM Product p WHERE p.product_name = '블랑드문 아크릴 장스탠드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand07.avif', 0, 0
FROM Product p WHERE p.product_name = '레이어 플로어 램프';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand08.avif', 0, 0
FROM Product p WHERE p.product_name = '미니아일랜드 장스탠드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand09.avif', 0, 0
FROM Product p WHERE p.product_name = '코니 아일랜드 장스탠드';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/stand', 'stand10.avif', 0, 0
FROM Product p WHERE p.product_name = '알렉스 장스탠드';


-- ===== 카테고리 12 : 차렵이불 File 매핑 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul01.avif', 0, 0
FROM Product p WHERE p.product_name = '카스테라 워싱 옥수수솜 차렵이불세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul02.avif', 0, 0
FROM Product p WHERE p.product_name = '호텔침구 클린코튼 옥수수솜 이불세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul03.avif', 0, 0
FROM Product p WHERE p.product_name = '유어메이트 항균 차렵이불 풀세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul04.avif', 0, 0
FROM Product p WHERE p.product_name = '빌리호텔 사계절 극세사 차렵이불세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul05.avif', 0, 0
FROM Product p WHERE p.product_name = '프렌치 스트라이프 옥수수솜 이불 S/SS';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul06.avif', 0, 0
FROM Product p WHERE p.product_name = '카스테라 스트라이프 한파용 차렵이불';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul07.avif', 0, 0
FROM Product p WHERE p.product_name = '수플레 겨울 극세사 옥수수솜 이불세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul08.avif', 0, 0
FROM Product p WHERE p.product_name = '돈워리 알러지케어 유칼립투스솜 이불';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul09.avif', 0, 0
FROM Product p WHERE p.product_name = '가드M2 사계절 극세사 차렵이불세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/ibul', 'ibul10.avif', 0, 0
FROM Product p WHERE p.product_name = '도즈 60수 순면 사계절 차렵이불세트';


-- ===== 크리스마스트리 File 매핑 =====
INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree01.avif', 0, 0
FROM Product p WHERE p.product_name = '하이엔드 피시본 투톤 무장식 대형 트리';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree02.avif', 0, 0
FROM Product p WHERE p.product_name = '클래식 LED 자작나무 트리';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree03.avif', 0, 0
FROM Product p WHERE p.product_name = '화이트 스케치 스노우 PE 전나무 트리';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree04.avif', 0, 0
FROM Product p WHERE p.product_name = '팝업트리 로얄 원터치 접이식 트리 풀세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree05.avif', 0, 0
FROM Product p WHERE p.product_name = '팝업트리 오리지널 캐슬 원터치 트리 풀세트';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree06.avif', 0, 0
FROM Product p WHERE p.product_name = '올인원 원터치 크리스마스 트리';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree07.avif', 0, 0
FROM Product p WHERE p.product_name = '트리 장식 풀세트 6종';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree08.avif', 0, 0
FROM Product p WHERE p.product_name = '하이엔드 피시본 그린 무장식 대형 트리';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree09.avif', 0, 0
FROM Product p WHERE p.product_name = 'LED탑별 장식 풀세트 트리';

INSERT IGNORE INTO File (uuid, product_id, save_dir, file_name, file_type, file_size)
SELECT UUID(), p.product_id, 'uploads/product/seed/tree', 'tree10.avif', 0, 0
FROM Product p WHERE p.product_name = '원터치 블랙트리 180cm 풀세트';
