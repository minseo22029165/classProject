/*
전화번호 부( Contact )

​-- 대리키 : 일련번호 -> pIdx
-- 이름, 전화번호, 주소, 이메일 <- 기본정보
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능

------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임

PhoneBook DDL : 테이블 정의서를 참고해서 DDL 작성 
*/
CREATE TABLE PHONEINFO_BASIC(
    idx                 NUMBER(6)           constraint pi_basic_PK         primary key,
    fr_name             VARCHAR2(20)        not null,
    fr_phonenumber      VARCHAR2(20)        not null,
    fr_email            VARCHAR2(20),
    fr_address          VARCHAR2(20),
    fr_regdate          DATE                DEFAULT SYSDATE
);

SELECT *
FROM phoneInfo_basic

-- 시퀀스 : 숫자 자동으로 늘어나게 
CREATE SEQUENCE SEQ_PIBASIC_IDX 
MINVALUE 0
START WITH 0
INCREMENT BY 1; 

INSERT INTO PHONEINFO_BASIC VALUES (SEQ_PIBASIC_IDX.NEXTVAL, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', SYSDATE);


-- 제약조건 확인 
select constraint_name, constraint_type 
from user_constraints 
where table_name = 'PHONEINFO_BASIC';

--DROP TABLE PHONEINFO_UNIV
CREATE TABLE PHONEINFO_UNIV(
    idx                 NUMBER(6)       CONSTRAINT PI_UNIV_IDX_PK   PRIMARY KEY,
    fr_u_major          VARCHAR2(20)    DEFAULT 'N',
    fr_u_year           NUMBER(1)       DEFAULT 1   CHECK (fr_u_year BETWEEN 1 AND 4),
    fr_ref              NUMBER(6),       
    CONSTRAINT PI_UNIV_REF_FK FOREIGN KEY(fr_ref) REFERENCES PHONEINFO_BASIC(IDX) 
);

INSERT INTO PHONEINFO_UNIV VALUES (3, 'COMPUTER', 2, SEQ_PIBASIC_IDX.CURRVAL);

SELECT *
FROM PHONEINFO_UNIV

CREATE TABLE PHONEINFO_COM(
    idx                 NUMBER(6)       CONSTRAINT PI_COM_IDX_PK    PRIMARY KEY,
    fr_c_company        VARCHAR2(20)    DEFAULT 'N',
    fr_ref              NUMBER(6)       NOT NULL    CONSTRAINT PI_COM_REF_FK REFERENCES PHONEINFO_BASIC(IDX) --FOREIGN KEY(fr_ref)  
)

INSERT INTO PHONEINFO_BASIC(IDX, FR_NAME, FR_PHONENUMBER) VALUES (SEQ_PIBASIC_IDX.NEXTVAL, '손흥민', '010-1111-1111');
INSERT INTO PHONEINFO_COM VALUES (1, '토트넘', SEQ_PIBASIC_IDX.CURRVAL);

SELECT *
FROM PHONEINFO_BASIC B
    INNER JOIN  PHONEINFO_COM C ON B.IDX = C.FR_REF 
    
    
DELETE 
  FROM PHONEINFO_COM
 WHERE FR_REF = 9
 
DELETE 
  FROM PHONEINFO_BASIC
 WHERE IDX = 9