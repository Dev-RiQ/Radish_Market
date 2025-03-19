-- [Test] --
CREATE DATABASE test_radish_market_db;
use test_radish_market_db;

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
    item_category_name VARCHAR(10) UNIQUE NOT NULL
    );
DESC item_category;
SELECT * FROM item_category;

-- 거래물
DROP TABLE items;
CREATE TABLE items (
	item_no INT AUTO_INCREMENT PRIMARY KEY,
    user_no INT NOT NULL, # FK
    item_category_no INT NOT NULL, # [item_category] item_category_no 참조
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
    user_no INT NOT NULL, # FK
    meet_no INT NOT NULL, # FK
    board_category_no INT NOT NULL, # [board_category] board_category_no 참조
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
    host_user_no INT NOT NULL, # FK
    meet_title VARCHAR(50) NOT NULL,
    meet_content VARCHAR(1000) NOT NULL,
    meet_category_no INT NOT NULL,
    age_min INT NOT NULL,
    age_max INT NOT NULL,
    meet_img VARCHAR(50) NOT NULL DEFAULT 'meetsDefaultImg'
	);
DESC meets;
SELECT * FROM meets;      

-- 후기
DROP TABLE reviews;
CREATE TABLE reviews (
	reviews_deg TINYINT NOT NULL,
    sell_user_no INT NOT NULL, # FK
    buy_user_no INT NOT NULL, # [users] user_no 참조
    item_no INT NOT NULL, # FK
    reviews_content VARCHAR(100) NOT NULL
    );    
DESC reviews;
SELECT * FROM reviews; 

-- 댓글 (컬럼 이름 수정해야함)
DROP TABLE comments;
CREATE TABLE comments (
	comments_no INT AUTO_INCREMENT PRIMARY KEY,
    board_no INT NOT NULL, # FK
    user_no INT NOT NULL, # FK
    comments_content VARCHAR(300) NOT NULL,
    comments_reg_datetime VARCHAR(20) NOT NULL,
    check_update TINYINT NOT NULL
     );   
DESC comments;
SELECT * FROM comments;      

-- 쪽지
DROP TABLE letters;
CREATE TABLE letters (
	letter_no INT AUTO_INCREMENT PRIMARY KEY,
    receive_user_no INT NOT NULL, # FK
	send_user_no INT NOT NULL, # [users] user_no 참조
    item_no INT NOT NULL, # FK
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
	user_no INT NOT NULL, # [users] user_no 참조
    item_no INT NOT NULL # FK
	);
DESC zzims;
SELECT * FROM zzims;         

-- 좋아요
DROP TABLE likes; 
CREATE TABLE likes (
    user_no INT NOT NULL, # [users] user_no 참조
    board_no INT NOT NULL # FK
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
    item_no INT NOT NULL # FK
    );
DESC item_img;
SELECT * FROM item_img; 
   
-- 모임 가입신청
DROP TABLE meet_join; 
CREATE TABLE meet_join (
    meet_join_no INT AUTO_INCREMENT PRIMARY KEY,
    meet_no INT NOT NULL, # FK
    user_no INT NOT NULL, # FK
    meet_join_content VARCHAR(300) NOT NULL
    );
DESC meet_join;
SELECT * FROM meet_join; 

-- 모임 회원
DROP TABLE meet_users; 
CREATE TABLE meet_users (
    meet_no INT NOT NULL, # FK
    user_no INT NOT NULL # FK
	);
DESC meet_users;
SELECT * FROM meet_users; 
    
-- 알람
DROP TABLE alarms;  
CREATE TABLE alarms (
	alarm_no INT AUTO_INCREMENT PRIMARY KEY,
    user_no INT NOT NULL, # FK
    alarm_category_no INT NOT NULL, # [alarms_category] alarms_category_no 참조
    link_no INT NOT NULL, # [items, boards] item_no, board_no 참조
    alarm_reg_datetime VARCHAR(20) NOT NULL,
	alarm_check TINYINT NOT NULL,
	alarm_content VARCHAR(300) NOT NULL
	);
DESC alarms;
SELECT * FROM alarms; 
    
-- 알람 카테고리
DROP TABLE alarm_category;  
CREATE TABLE alarm_category (
	alarm_category_no INT AUTO_INCREMENT PRIMARY KEY,
    alarm_name VARCHAR(10) NOT NULL,
    alarm_content VARCHAR(50) NOT NULL
    );
DESC alarm_category;
SELECT * FROM alarm_category; 

-- 캘린더
DROP TABLE calendars;  
CREATE TABLE calendars (
	calendar_no INT AUTO_INCREMENT PRIMARY KEY,
    main_user_no INT NOT NULL, # FK
    sub_user_no INT NOT NULL, # [users] sub_user_no 참조
    meet_no INT NOT NULL, # FK
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
	item_no INT NOT NULL, -- FK
    user_no INT NOT NULL, -- [users] user_no 참조
    check_reviewed INT NOT NULL
    );
DESC carts;
SELECT * FROM carts; 

-- [필수 카테고리, 이모지 데이터 삽입] -- 

-- item_category (20개)
INSERT INTO item_category (item_category_name) VALUES
('미분류'),
('디지털기기'),
('생활가전'),
('가구/인테리어'),
('생활/주방'),
('유아동'),
('유아도서'),
('여성의륰'),
('여성잡화'),
('남성패션/잡화'),
('뷰티/미용'),
('스포츠/레저'),
('취미/게임/음반'),
('도서'),
('티켓/교환권'),
('가공식품'),
('건강기능식품'),
('반려동물용품'),
('식물'),
('기타 중고물품');
 
-- board_category (19개)
INSERT INTO board_category (board_category_name) VALUES
('미분류'),
('인기글'),
('맛집'),
('반려동물'),
('운동'),
('생활/편의'),
('분실/실종'),
('병원/약국'),
('고민/사연'),
('동네친구'),
('이사/시공'),
('주거/부동산'),
('교육'),
('취미'),
('동네사건사고'),
('동네풍경'),
('미용'),
('임신/육아'),
('일반');
 
-- meet_category (13개)
INSERT INTO meet_category (meet_category_name) VALUES
('미분류'),
('운동'),
('자기계발'),
('동네친구'),
('아웃도어/여행'),
('가족/육아'),
('반려동물'),
('음식/음료'),
('취미/오락'),
('독서/인문학'),
('문화//예술'),
('음악/악기'),
('기타');

-- alarm_category (9개)
INSERT INTO alarm_category (ararm_category_name, ararm_category_content) VALUES
('좋아요', '회원님의 게시글이 좋아요를 받았습니다.'),  
('댓글', '회원님의 게시글에 새로운 댓글이 등록되었습니다.'),  
('찜', '회원님의 아이템이 찜 목록에 추가되었습니다.'),  
('상품 리뷰', '판매하신 물품에 새로운 리뷰가 작성되었습니다.'),  
('리뷰 작성 요청', '구매하신 상품에 대한 리뷰를 작성해 주세요.'),  
('쪽지', '새로운 쪽지가 도착했습니다.'),  
('일정 초대', '회원님이 새로운 일정에 추가되었습니다.'),  
('모임 가입 신청', '모임 가입 신청이 접수되었습니다.'),  
('모임 가입 승인', '회원님의 모임 가입이 승인되었습니다.'); 

-- emojis (6개)
INSERT INTO emojis (min_deg, max_deg, emoji) VALUES
(0, 20, '😰'),
(21, 35, '🙁'),
(36, 48, '🙂'),
(49, 63, '😀'),
(64, 80, '😄'),
(81, 100, '😆');