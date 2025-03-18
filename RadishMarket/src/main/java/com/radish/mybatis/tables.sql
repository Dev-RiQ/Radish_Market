-- Test
DROP DATABASE test_radish_market_db;
CREATE DATABASE test_radish_market_db;
use test_radish_market_db;

-- Init
DROP DATABASE radish_market_db;
CREATE DATABASE radish_market_db;
use radish_market_db;

-- 유저
DROP TABLE users;
CREATE TABLE users (
	user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(12) NOT NULL,
    user_pw VARCHAR(16) NOT NULL,
    user_name VARCHAR(10) NOT NULL,
    user_age INT  NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_nickname VARCHAR(6) NOT NULL,
    user_address VARCHAR(100) NOT NULL,
    user_img VARCHAR(50) NOT NULL DEFAULT 'usersDefaultImg',
    user_phone VARCHAR(13) NOT NULL,
    user_reg_datetime VARCHAR(20) NOT NULL,
    user_dir_x VARCHAR(20) NOT NULL,
    user_dir_y VARCHAR(20)  NOT NULL,
    user_city VARCHAR(10) NOT NULL,
    user_gu VARCHAR(10) NOT NULL,
    user_dong VARCHAR(10) NOT NULL,
    user_deg INT  NOT NULL
    );
DESC users;
SELECT * FROM users;

-- 거래물 카테고리 
DROP TABLE item_category;     
CREATE TABLE item_category (
    item_category_no INT AUTO_INCREMENT PRIMARY KEY,
    item_category_name VARCHAR(10) NOT NULL
    );
DESC item_category;
SELECT * FROM item_category;

-- 거래물
DROP TABLE items;
CREATE TABLE items (
	item_no INT AUTO_INCREMENT PRIMARY KEY,
    user_no INT NOT NULL, -- FK
    item_category_no INT NOT NULL, -- [item_category] item_category_no 참조
    item_name VARCHAR(50) NOT NULL,
    item_content VARCHAR(1000) NOT NULL,
    item_price INT UNSIGNED NOT NULL,
    item_reg_datetime VARCHAR(20) NOT NULL,
    item_update_datetime VARCHAR(20) NOT NULL,
    item_status INT NOT NULL,
    item_hits INT NOT NULL
    );
DESC items;
SELECT * FROM items;

-- 자유 게시판 (동네 생활)
DROP TABLE boards;
CREATE TABLE boards (
	board_no INT AUTO_INCREMENT PRIMARY KEY,
    user_no INT NOT NULL, -- FK
    meet_no INT NOT NULL, -- FK
    board_category_no INT NOT NULL, -- [board_category] board_category_no 참조
    board_title VARCHAR(50) NOT NULL,
    board_content VARCHAR(1000) NOT NULL,
    board_reg_datetime VARCHAR(20) NOT NULL,
    board_update_datetime VARCHAR(20) NOT NULL,
    board_img VARCHAR(50) NOT NULL DEFAULT 'boardsDefaultImg',
    board_hits INT NOT NULL
       );
DESC boards;
SELECT * FROM boards;       

-- 모임
DROP TABLE meets;
CREATE TABLE meets (
	meet_no INT AUTO_INCREMENT PRIMARY KEY,
    host_user_no INT NOT NULL, -- FK
    meet_title VARCHAR(50) NOT NULL,
    meet_content VARCHAR(1000) NOT NULL,
    meet_category INT NOT NULL,
    age_min INT NOT NULL,
    age_max INT NOT NULL,
    meet_img VARCHAR(50) NOT NULL DEFAULT 'meetsDefaultImg'
	);
DESC meets;
SELECT * FROM meets;      

-- 후기
DROP TABLE reviews;
CREATE TABLE reviews (
	review_deg TINYINT NOT NULL,
    sell_user_no INT NOT NULL, -- FK
    buy_user_no INT NOT NULL, -- [users] user_no 참조
    item_no INT NOT NULL, -- FK
    review_content VARCHAR(100) NOT NULL
    );    
DESC reviews;
SELECT * FROM reviews; 

-- 댓글
DROP TABLE comments;
CREATE TABLE comments (
	comment_no INT AUTO_INCREMENT PRIMARY KEY,
    board_no INT NOT NULL, -- FK
    user_no INT NOT NULL, -- FK
    comment_content VARCHAR(300) NOT NULL,
    comment_reg_datetime VARCHAR(20) NOT NULL,
    check_update TINYINT NOT NULL
     );   
DESC comments;
SELECT * FROM comments;      

-- 쪽지
DROP TABLE letters;
CREATE TABLE letters (
	letter_no INT AUTO_INCREMENT PRIMARY KEY,
    receive_user_no INT NOT NULL, -- FK
	send_user_no INT NOT NULL, -- [users] user_no 참조
    item_no INT NOT NULL, -- FK
    letter_title VARCHAR(50) NOT NULL,
    letter_content VARCHAR(300) NOT NULL,
    letter_reg_datetime VARCHAR(20) NOT NULL,
    letter_check TINYINT NOT NULL
    );
DESC letters;
SELECT * FROM letters;   

-- 찜
DROP TABLE zzims; 
CREATE TABLE zzims (
	user_no INT NOT NULL, -- [users] user_no 참조
    item_no INT NOT NULL -- FK
	);
DESC zzims;
SELECT * FROM zzims;   

-- 좋아요
DROP TABLE likes; 
CREATE TABLE likes (
    user_no INT NOT NULL, -- [users] user_no 참조
    board_no INT NOT NULL -- FK
    );
DESC likes;
SELECT * FROM likes;     

-- 게시글 카테고리
DROP TABLE board_category; 
CREATE TABLE board_category (
    board_category_no INT AUTO_INCREMENT PRIMARY KEY,
    board_category_name VARCHAR(10) NOT NULL
    );
DESC board_category;
SELECT * FROM board_category;    

-- 모임 카테고리     
DROP TABLE meet_category;     
CREATE TABLE meet_category (
    meet_category_no INT AUTO_INCREMENT PRIMARY KEY,
    meet_category_name VARCHAR(10) NOT NULL
    );
DESC meet_category;
SELECT * FROM meet_category; 

-- 아이템 이미지    
DROP TABLE item_img; 
CREATE TABLE item_img (
    item_img VARCHAR(50) NOT NULL,
    item_no INT NOT NULL -- FK
    );
DESC item_img;
SELECT * FROM item_img; 
   
-- 모임 가입신청
DROP TABLE meet_join; 
CREATE TABLE meet_join (
    meet_join_no INT AUTO_INCREMENT PRIMARY KEY,
    meet_no INT NOT NULL, -- FK
    user_no INT NOT NULL, -- FK
    meet_join_content VARCHAR(300) NOT NULL
    );
DESC meet_join;
SELECT * FROM meet_join; 

-- 모임 회원
DROP TABLE meet_users; 
CREATE TABLE meet_users (
    meet_no INT NOT NULL, -- FK
    user_no INT NOT NULL -- FK
	);
DESC meet_users;
SELECT * FROM meet_users; 
    
-- 알람
DROP TABLE alarms;  
CREATE TABLE alarms (
	alarm_no INT AUTO_INCREMENT PRIMARY KEY,
    user_no INT NOT NULL, -- FK
    alarm_category_no INT NOT NULL, -- [alarms_category] alarms_category_no 참조
    link_no INT NOT NULL, -- [items, boards] item_no, board_no 참조
    alarm_reg_datetime VARCHAR(20) NOT NULL,
	alarm_check TINYINT NOT NULL
	);
DESC alarms;
SELECT * FROM alarms; 
    
-- 알람 카테고리
DROP TABLE alarm_category;  
CREATE TABLE alarm_category (
	alarm_category_no INT AUTO_INCREMENT PRIMARY KEY,
    alarm_category_name VARCHAR(10) NOT NULL,
    alarm_category_content VARCHAR(300) NOT NULL
    );
DESC alarm_category;
SELECT * FROM alarm_category; 

-- 캘린더
DROP TABLE calendars;  
CREATE TABLE calendars (
	calendar_no INT AUTO_INCREMENT PRIMARY KEY,
    main_user_no INT NOT NULL, -- FK
    sub_user_no INT NOT NULL, -- [users] sub_user_no 참조
    meet_no INT NOT NULL, -- FK
    address VARCHAR(100) NOT NULL,
    calendar_dir_x VARCHAR(20) NOT NULL,
    calendar_dir_y VARCHAR(20) NOT NULL,
    calendar_datetime VARCHAR(20) NOT NULL,
    calendar_title VARCHAR(20) NOT NULL,
    calendar_content VARCHAR(100) NOT NULL
    );
DESC calendars;
SELECT * FROM calendars; 

-- 이모지
DROP TABLE emojis; 
CREATE TABLE emojis(
	min_deg INT NOT NULL,
    max_deg INT NOT NULL,
    emoji VARCHAR(10) NOT NULL,
    CHECK (min_deg >= 0 AND max_deg <= 100)
    )CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
DESC emojis;
SELECT * FROM emojis; 

-- 구매목록
DROP TABLE carts; 
CREATE TABLE carts(
	item_no INT NOT NULL,
    user_no INT NOT NULL,
    check_reviewed INT NOT NULL
    );
DESC carts;
SELECT * FROM carts; 

-- [더미데이터 삽입] --
-- 유저
INSERT INTO users (user_id, user_pw, user_name, user_age, user_email, user_nickname, user_address, user_img, user_phone, user_reg_datetime, user_dir_x, user_dir_y, user_city, user_gu, user_dong, user_deg) VALUES
('alice123', 'pass1234', '김민지', 25, 'alice123@gmail.com', '민지', '서울특별시 강남구 역삼동 123-45', 'usersDefaultImg', '010-1234-5678', '2025-03-01 10:00:00', '37.5013', '127.0396', '서울', '강남구', '역삼동', 5),
('bob456', 'pass5678', '이준호', 30, 'bob456@naver.com', '준호', '서울특별시 서초구 서초동 456-78', 'usersDefaultImg', '010-2345-6789', '2025-03-02 12:30:00', '37.489', '127.018', '서울', '서초구', '서초동', 4),
('charlie789', 'pass9012', '박수영', 28, 'charlie789@daum.net', '수영', '서울특별시 송파구 잠실동 789-12', 'usersDefaultImg', '010-3456-7890', '2025-03-03 15:45:00', '37.5112', '127.0981', '서울', '송파구', '잠실동', 3);

-- 거래물 카테고리
INSERT INTO item_category (item_category_name) VALUES
('의류'),
('가전'),
('가구'),
('도서');

-- 거래물
INSERT INTO items (user_no, item_category_no, item_name, item_content, item_price, item_reg_datetime, item_update_datetime, item_status, item_hits) VALUES
(1, 1, '흰색 티셔츠', '새 상품, M 사이즈, 면 소재', 15000, '2025-03-04 09:00:00', '2025-03-04 09:00:00', 1, 10),
(2, 2, '전자레인지', '사용 1년, 상태 좋음', 50000, '2025-03-04 11:00:00', '2025-03-04 11:00:00', 1, 25),
(3, 3, '책상', '원목 책상, 약간 사용감 있음', 30000, '2025-03-05 14:00:00', '2025-03-05 14:00:00', 1, 15);

INSERT INTO items (user_no, item_category_no, item_name, item_content, item_price, item_reg_datetime, item_update_datetime, item_status, item_hits) VALUES
(1, 1, '삼성 노트북', '사용 1년, 상태 양호', 450000, '2025-03-15 10:00:00', '2025-03-15 10:00:00', 0, 25),
(2, 2, '아이폰 13', '32GB, 흠집 없음', 600000, '2025-03-14 15:30:00', '2025-03-14 15:30:00', 1, 50),
(3, 3, '자전거', 'MTB, 새것과 같음', 150000, '2025-03-16 09:15:00', '2025-03-16 09:15:00', 0, 10),
(4, 4, '책상', '목재, 간단한 디자인', 80000, '2025-03-13 12:45:00', '2025-03-13 12:45:00', 2, 75),
(5, 5, '헤드폰', '소니 WH-1000XM4', 250000, '2025-03-17 08:20:00', '2025-03-17 08:20:00', 0, 30),
(6, 1, 'LG 모니터', '27인치, Full HD', 200000, '2025-03-15 14:00:00', '2025-03-15 14:00:00', 1, 15),
(7, 2, '갤럭시 워치', '사용 6개월', 120000, '2025-03-16 11:10:00', '2025-03-16 11:10:00', 0, 40),
(8, 3, '운동화', '나이키, 사이즈 270', 70000, '2025-03-14 16:30:00', '2025-03-14 16:30:00', 2, 90),
(9, 4, '의자', '사무용, 조절 가능', 90000, '2025-03-13 09:00:00', '2025-03-13 09:00:00', 0, 20),
(10, 5, '게임 콘솔', 'PS5, 패드 포함', 500000, '2025-03-17 13:45:00', '2025-03-17 13:45:00', 1, 60),
(1, 1, '애플 맥북', '2019년형, 256GB', 700000, '2025-03-15 11:30:00', '2025-03-15 11:30:00', 0, 35),
(2, 2, '아이패드', '9세대, 64GB', 300000, '2025-03-16 10:15:00', '2025-03-16 10:15:00', 2, 45),
(3, 3, '캠핑 텐트', '4인용, 방수', 180000, '2025-03-14 14:00:00', '2025-03-14 14:00:00', 0, 12),
(4, 4, '책장', '중고, 높이 1.8m', 60000, '2025-03-13 15:20:00', '2025-03-13 15:20:00', 1, 80),
(5, 5, '스피커', 'JBL, 블루투스', 100000, '2025-03-17 07:50:00', '2025-03-17 07:50:00', 0, 25),
(6, 1, '델 노트북', 'i5, 8GB RAM', 350000, '2025-03-15 13:00:00', '2025-03-15 13:00:00', 2, 70),
(7, 2, '삼성 태블릿', '10인치, 중고', 150000, '2025-03-16 12:30:00', '2025-03-16 12:30:00', 0, 30),
(8, 3, '피아노', '전자, 사용감 있음', 400000, '2025-03-14 17:45:00', '2025-03-14 17:45:00', 1, 55),
(9, 4, '소파', '2인용, 가죽', 200000, '2025-03-13 10:10:00', '2025-03-13 10:10:00', 0, 15),
(10, 5, '드론', 'DJI Mini 2', 300000, '2025-03-17 14:15:00', '2025-03-17 14:15:00', 2, 85),
(1, 1, 'HP 노트북', '사용 2년', 250000, '2025-03-15 12:00:00', '2025-03-15 12:00:00', 0, 20),
(2, 2, '구글 픽셀', '6 Pro, 128GB', 400000, '2025-03-16 09:45:00', '2025-03-16 09:45:00', 1, 65),
(3, 3, '낚싯대', '탄소재, 2.4m', 50000, '2025-03-14 13:30:00', '2025-03-14 13:30:00', 0, 10),
(4, 4, 'TV', '32인치, LED', 150000, '2025-03-13 16:00:00', '2025-03-13 16:00:00', 2, 90),
(5, 5, '마이크', '콘덴서, USB', 80000, '2025-03-17 08:00:00', '2025-03-17 08:00:00', 0, 30),
(6, 1, '레노버 노트북', 'i7, 16GB', 600000, '2025-03-15 14:30:00', '2025-03-15 14:30:00', 1, 40),
(7, 2, '에어팟 프로', '1세대, 상태 좋음', 120000, '2025-03-16 11:00:00', '2025-03-16 11:00:00', 0, 50),
(8, 3, '서핑보드', '초보용, 7피트', 250000, '2025-03-14 15:15:00', '2025-03-14 15:15:00', 2, 70),
(9, 4, '침대', '싱글, 매트 포함', 180000, '2025-03-13 11:30:00', '2025-03-13 11:30:00', 0, 25),
(10, 5, '카메라', '캐논 EOS M50', 350000, '2025-03-17 13:00:00', '2025-03-17 13:00:00', 1, 60);

-- 모임
INSERT INTO meets (host_user_no, meet_title, meet_content, meet_category, age_min, age_max, meet_img) VALUES
(1, '강남 독서 모임', '매주 토요일 책 읽고 토론하는 모임입니다.', 1, 20, 40, 'meetsDefaultImg'),
(2, '서초 러닝 클럽', '아침 러닝 함께 하실 분 모집!', 2, 25, 45, 'meetsDefaultImg');

-- 게시글 카테고리
INSERT INTO board_category (board_category_name) VALUES
('질문'),
('정보공유'),
('동네소식');

-- 자유 게시판 (동네 생활)
INSERT INTO boards (user_no, meet_no, board_category_no, board_title, board_content, board_reg_datetime, board_update_datetime, board_img, board_hits) VALUES
(1, 1, 1, '독서 모임 시간 문의', '이번 주 토요일 몇 시에 만나나요?', '2025-03-06 10:00:00', '2025-03-06 10:00:00', 'boardsDefaultImg', 5),
(2, 2, 2, '러닝 코스 추천', '서초 근처 좋은 러닝 코스 아시는 분?', '2025-03-06 11:00:00', '2025-03-06 11:00:00', 'boardsDefaultImg', 8);

-- 후기
INSERT INTO reviews (review_deg, sell_user_no, buy_user_no, item_no, review_content) VALUES
(5, 1, 2, 1, '티셔츠 상태 정말 좋네요! 추천합니다.'),
(4, 2, 3, 2, '전자레인지 잘 작동해요. 가격도 적당.');

-- 댓글
INSERT INTO comments (board_no, user_no, comment_content, comment_reg_datetime, check_update) VALUES
(1, 2, '오후 2시로 알고 있습니다!', '2025-03-06 10:30:00', 0),
(2, 3, '반포 한강공원 코스 추천드려요.', '2025-03-06 11:30:00', 0);

-- 쪽지
INSERT INTO letters (receive_user_no, send_user_no, item_no, letter_title, letter_content, letter_reg_datetime, letter_check) VALUES
(1, 2, 1, '티셔츠 구매 문의', '티셔츠 아직 있나요? 직거래 가능할까요?', '2025-03-06 12:00:00', 0),
(2, 3, 2, '전자레인지 문의', '전자레인지 상태 더 자세히 알려주세요.', '2025-03-06 13:00:00', 0);

-- 찜
INSERT INTO zzims (user_no, item_no) VALUES
(2, 1),
(3, 2),
(1, 3);

-- 좋아요
INSERT INTO likes (user_no, board_no) VALUES
(2, 1),
(3, 1),
(1, 2);

-- 모임 카테고리
INSERT INTO meet_category (meet_category_name) VALUES
('독서'),
('운동'),
('취미');

-- 아이템 이미지
INSERT INTO item_img (item_img, item_no) VALUES
('tshirt.jpg', 1),
('microwave.jpg', 2),
('desk.jpg', 3);

-- 모임 가입신청
INSERT INTO meet_join (meet_no, user_no, meet_join_content) VALUES
(1, 2, '독서 모임 참여하고 싶습니다! 책 읽는 거 좋아해요.'),
(2, 3, '러닝 클럽 가입 희망합니다. 매일 아침 러닝해요.');

-- 모임 회원
INSERT INTO meet_users (meet_no, user_no) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3);

-- 알람 카테고리
INSERT INTO alarm_category (alarm_category_name, alarm_category_content) VALUES
('좋아요','누군가 게시글을 좋아합니다.'),
('댓글','게시글에 댓글이 추가되었습니다.'),
('찜','누군가 아이템을 찜했습니다.'),
('리뷰','판매 물품에 리뷰가 추가되었습니다.'),
('리뷰','구매한 품목의 리뷰를 작성해주세요.'),
('쪽지','새로운 쪽지가 있습니다.'),
('일정','누군가 새로운 일정에 나를 추가했습니다.'),
('모임','누군가 모임에 가입 신청을 했습니다.'),
('모임','신청했던 모임에 가입되었습니다.');

-- 알람
INSERT INTO alarms (user_no, alarm_category_no, link_no, alarm_reg_datetime, alarm_check) VALUES
(1, 1, 1, '2025-03-06 12:00:00', 0),
(2, 2, 1, '2025-03-06 10:30:00', 0),
(1, 3, 2, '2025-03-06 11:00:00', 0),
(1, 5, 2, '2025-03-06 11:00:00', 0);

-- 캘린더
INSERT INTO calendars (main_user_no, sub_user_no, meet_no, address, calendar_dir_x, calendar_dir_y, calendar_datetime, calendar_title, calendar_content) VALUES
(1, 2, 1, '서울특별시 강남구 역삼동 카페', '37.5013', '127.0396', '2025-03-07 14:00:00', '독서 모임', '이번 주 책: "데미안"'),
(2, 3, 2, '서울특별시 서초구 반포 한강공원', '37.489', '127.018', '2025-03-08 07:00:00', '아침 러닝', '5km 코스 예정');

-- 이모지
INSERT INTO emojis (min_deg, max_deg, emoji) VALUES
(0, 20, '😰'),
(21, 35, '🙁'),
(36, 48, '🙂'),
(49, 63, '😀'),
(64, 80, '😄'),
(81, 100, '😆');

-- 구매목록
INSERT INTO carts (item_no, user_no, check_reviewed) VALUES
(1, 1, 0),
(2, 1, 0),
(3, 1, 1),
(4, 1, 0);


-- [외래 키 설정] --
	-- items FK
    ALTER TABLE items
    ADD CONSTRAINT fk_items_user_no 
    FOREIGN KEY (user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- boards FK
    ALTER TABLE boards
    ADD CONSTRAINT fk_boards_user_no 
    FOREIGN KEY (user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- boards FK
    ALTER TABLE boards
    ADD CONSTRAINT fk_boards_meet_no 
    FOREIGN KEY (meet_no) 
    REFERENCES meets(meet_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- meets FK
    ALTER TABLE meets
    ADD CONSTRAINT fk_meets_host_user_no 
    FOREIGN KEY (host_user_no) 
    REFERENCES users(user_no) 
	ON DELETE CASCADE ON UPDATE CASCADE;
	
	-- reviews FK
    ALTER TABLE reviews
    ADD CONSTRAINT fk_reviews_sell_user_no 
    FOREIGN KEY (sell_user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- reviews FK
    ALTER TABLE reviews
    ADD CONSTRAINT fk_reviews_item_no 
    FOREIGN KEY (item_no) 
    REFERENCES items(item_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- comments FK
    ALTER TABLE comments
    ADD CONSTRAINT fk_comments_board_no 
    FOREIGN KEY (board_no) 
    REFERENCES boards(board_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- comments FK
    ALTER TABLE comments
    ADD CONSTRAINT fk_comments_user_no 
    FOREIGN KEY (user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- receive_user_no (users)
    ALTER TABLE letters
		ADD CONSTRAINT fk_letters_receive_user_no 
    FOREIGN KEY (receive_user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- item_no (items)
		ALTER TABLE letters
		ADD CONSTRAINT fk_letters_item_no 
    FOREIGN KEY (item_no) 
    REFERENCES items(item_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- zzims FK
		ALTER TABLE zzims
    ADD CONSTRAINT fk_zzims_item_no 
    FOREIGN KEY (item_no) 
    REFERENCES items(item_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- likes FK
    ALTER TABLE likes
    ADD CONSTRAINT fk_likes_board_no 
    FOREIGN KEY (board_no) 
    REFERENCES boards(board_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- item_img FK
    ALTER TABLE item_img
    ADD CONSTRAINT fk_item_img_item_no 
    FOREIGN KEY (item_no) 
    REFERENCES items(item_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- meet_join FK
    ALTER TABLE meet_join
		ADD CONSTRAINT fk_meet_join_meet_no 
    FOREIGN KEY (meet_no) 
    REFERENCES meets(meet_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- meet_join FK
    ALTER TABLE meet_join
		ADD CONSTRAINT fk_meet_join_user_no 
    FOREIGN KEY (user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- meet_users FK
    ALTER TABLE meet_users
    ADD CONSTRAINT fk_meet_users_meet_no 
    FOREIGN KEY (meet_no) 
    REFERENCES meets(meet_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
	-- meet_users FK
    ALTER TABLE meet_users
    ADD CONSTRAINT fk_meet_users_user_no 
    FOREIGN KEY (user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- alarms FK
    ALTER TABLE alarms
    ADD CONSTRAINT fk_alarms_user_no 
    FOREIGN KEY (user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- calendar FK
    ALTER TABLE calendars
    ADD CONSTRAINT fk_calendars_main_user_no 
    FOREIGN KEY (main_user_no) 
    REFERENCES users(user_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;
    
    -- calendar FK
    ALTER TABLE calendars
    ADD CONSTRAINT fk_calendars_meet_no 
    FOREIGN KEY (meet_no) 
    REFERENCES meets(meet_no) 
    ON DELETE CASCADE ON UPDATE CASCADE;