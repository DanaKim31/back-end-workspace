-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)
DROP TABLE tb_publisher;
CREATE TABLE tb_publisher (
	PUB_NO INT AUTO_INCREMENT PRIMARY KEY,
    PUB_NAME VARCHAR(20) NOT NULL,
    PHONE VARCHAR(13)
);
INSERT INTO tb_publisher(PUB_NAME, PHONE) VALUES('천그루숲', '010-8748-0784');
INSERT INTO tb_publisher(PUB_NAME, PHONE) VALUES('골든래빗', '0505-398-0505');
INSERT INTO tb_publisher(PUB_NAME, PHONE) VALUES('윌북', '031-955-3777');

select * from tb_publisher;



-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (tb_book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(tb_publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정
DROP TABLE tb_book;
CREATE TABLE tb_book (
	BK_NO INT AUTO_INCREMENT PRIMARY KEY,
    BK_TITLE VARCHAR(30) NOT NULL,
    BK_AUTHOR VARCHAR(10) NOT NULL,
    BK_PRICE INT,
    BK_PUB_NO INT, 
    FOREIGN KEY (BK_PUB_NO) REFERENCES tb_publisher(PUB_NO) ON DELETE CASCADE
);
INSERT INTO tb_book(BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO) VALUES ('오늘부터 개발자', '김병욱', '16800', 1);
INSERT INTO tb_book(BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO) VALUES ('요즘 우아한 개발', '우아한 형제들', '24000', 2);
INSERT INTO tb_book(BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO) VALUES ('프로덕트 매니저 원칙', '장홍석', '22000', 2);
INSERT INTO tb_book(BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO) VALUES ('코딩 좀 아는 사람', '제러미 키신', '17800', 3);
INSERT INTO tb_book(BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO) VALUES ('그렇게 쓰면 아무도 안 읽습니다', '전주경', '19800', 3);

SELECT * FROM tb_book;



-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (tb_member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜
CREATE TABLE tb_member(
	MEMBER_NO INT AUTO_INCREMENT PRIMARY KEY,
    MEMBER_ID VARCHAR(10) UNIQUE,
    MEMBER_PWD VARCHAR(10) NOT NULL,
    MEMBER_NAME VARCHAR(3) NOT NULL,
    GENDER CHAR (1),
    ADDRESS VARCHAR(10),
    PHONE VARCHAR(13),
    STATUS CHAR(1) DEFAULT 'N',
    ENROLL_DATE DATE DEFAULT (current_date),
    CONSTRAINT GENDER_check CHECK (GENDER IN ('M', 'F')),
    CONSTRAINT STATUS_check CHECK (STATUS IN ('Y', 'N'))
);
INSERT INTO tb_member(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER, ADDRESS, PHONE, STATUS, ENROLL_DATE) 
			VALUES ('user01', 'pass01', '홍길동', 'M', '서울시 강서구', '010-1111-2222', default, default);
INSERT INTO tb_member(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER, ADDRESS, PHONE, STATUS, ENROLL_DATE) 
			VALUES ('user02', 'pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444', default, default);
INSERT INTO tb_member(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER, ADDRESS, PHONE, STATUS, ENROLL_DATE) 
			VALUES ('user03', 'pass04', '강길순', 'F', '경기도 광주시', '010-4444-5555', default, default);

SELECT * FROM tb_member;



-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(tb_rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(tb_member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(tb_book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
CREATE TABLE tb_rent (
	RENT_NO INT PRIMARY KEY,
    RENT_MEM_NO INT,
    RENT_BOOK_NO INT,
    RENT_DATE DATE DEFAULT (current_date),
    FOREIGN KEY (RENT_MEM_NO) REFERENCES tb_member(MEMBER_NO),
    FOREIGN KEY (RENT_BOOK_NO) REFERENCES tb_book(BK_NO) ON DELETE SET NULL    
);
INSERT INTO tb_rent VALUES(1, 1, 2, default);
INSERT INTO tb_rent VALUES(2, 1, 3, default);
INSERT INTO tb_rent VALUES(3, 2, 1, default);
INSERT INTO tb_rent VALUES(4, 2, 2, default);
INSERT INTO tb_rent VALUES(5, 1, 5, default);

SELECT * FROM tb_rent;



-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
-- CREATE TABLE BK_NO2
SELECT MEMBER_NAME "회원 이름", MEMBER_ID "아이디", RENT_DATE "대여일", ADDDATE(RENT_DATE, interval 7 day) "반납 예정일"
FROM tb_member JOIN tb_rent ON (MEMBER_NO = RENT_MEM_NO)
WHERE RENT_BOOK_NO = 2;

select * from BK_NO2;



-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
SELECT BK_TITLE 도서명, PUB_NAME 출판사명, RENT_DATE 대여일, ADDDATE(RENT_DATE, interval 7 day) "반납 예정일"
FROM tb_book JOIN tb_publisher ON (BK_PUB_NO = PUB_NO)
			 JOIN tb_rent ON (BK_NO = RENT_BOOK_NO)
             JOIN tb_member ON (RENT_MEM_NO = MEMBER_NO)
WHERE MEMBER_NO = 1;






