CREATE TABLE test_tbl (
    no              number(4),
    user_name       varchar2(10),
    user_id         varchar2(16),
    user_password   varchar2(12),
    reg_date        Timestamp DEFAULT sysdate
);

CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    SAL NUMBER(7, 2)
);

DESC EMP01;

-- EMP TABLE 복사 (제약조건은 복사되지 않는다.)
CREATE TABLE EMP02
AS 
SELECT * FROM EMP

DESC EMP02;

-- EMP04에 원하는 컬럼만 복사
CREATE TABLE EMP04
AS 
SELECT *
FROM EMP
WHERE ROWNUM <= 3


CREATE TABLE EMP05
AS 
SELECT * 
FROM EMP 
WHERE 1 = 2

-- RENAME 
RENAME EMP05 TO NEW_EMP;

-- 기존 테이블에 속성을 추가 
DESC EMP01;

ALTER TABLE EMP01 
ADD (DEPTNO NUMBER(2));

-- 기존 테이블의 컬럼 변경 : 새롭게 정의된 컬럼으로 교체하는것
ALTER TABLE EMP01 
MODIFY (DEPTNO NUMBER(10));


-- 기존 테이블의 컬럼 삭제 : 데이터도 모두 삭제 
ALTER TABLE EMP01
DROP (DEPTNO);

-- EMP01 테이블 삭제
DROP TABLE EMP01;

CREATE TABLE EMP01(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR(9),
    DEPTNO NUMBER(2)
);

INSERT INTO EMP01 VALUES(NULL, NULL, 'TESTER', 10);


DROP TABLE EMP02;
CREATE TABLE EMP02(
    EMPNO NUMBER(4) UNIQUE, 
    ENAME VARCHAR2(10) NOT NULL
)

DROP TABLE EMP03;
CREATE TABLE EMP03(
    EMPNO NUMBER(4) NOT NULL    UNIQUE, 
    ENAME VARCHAR2(10) NOT NULL
)

-- 기본키 제약: 기본키 설정을 통해서 NOT NULL, UNIQUE 
DROP TABLE EMP04;
CREATE TABLE EMP04 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL
);

INSERT INTO EMP04 VALUES (1, 'TEST');

-- 외래키제약조건 : 참조하는 테이블과 컬럼을 정의 (NULL은 가능)
DROP TABLE EMP05;
CREATE TABLE EMP05 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    DEPTNO NUMBER(2) REFERENCES DEPT(DEPTNO)
);

-- 60은 안되는데 NULL은 가능 
INSERT INTO EMP05 VALUES (1, 'TEST', 60);
INSERT INTO EMP05 VALUES (1, 'TEST', NULL);

-- CHECK : 특정 범위를 제한할수있다.
CREATE TABLE EMP06 (
    EMPNO NUMBER(4) PRIMARY KEY,
    SAL NUMBER(7,2) CHECK (SAL >= 800)
);

-- DEFAULT : INSERT 시에 데이터가 입력되지 않을때 자동으로 등록 
CREATE TABLE EMP07 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    SAL NUMBER(7, 2) CHECK (SAL >= 500),
    COMM NUMBER(7, 2) DEFAULT 0,
    HIREDATE DATE DEFAULT SYSDATE
);

INSERT INTO EMP07(EMPNO, ENAME, SAL) VALUES(1, 'TEST', 3000);

-- 제약조건에 이름부여
CREATE TABLE EMP08 (
    EMPNO NUMBER(4) CONSTRAINT EMP08_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP08_ENAME_NN NOT NULL,
    SAL NUMBER(7, 2) CONSTRAINT EMP08_SAL_CK CHECK (SAL >= 500),
    COMM NUMBER(7, 2) DEFAULT 0,
    HIREDATE DATE DEFAULT SYSDATE
);

INSERT INTO EMP08(EMPNO, ENAME, SAL) VALUES(1, 'TEST', 3000);

-- 테이블 레벨에서 제약조건 정의
CREATE TABLE EMP09 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(10), 
    CONSTRAINT EMP09_EMPNO_PK PRIMARY KEY (EMPNO),
    CONSTRAINT EMP09_JOB_UK UNIQUE (JOB),
    CONSTRAINT EMP09_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO)
);    
    
-- 서브쿼리를 이용해서 데이터 입력
DROP TABLE DEPT02;

CREATE TABLE DEPTO2 
AS 
SELECT * 
  FROM DEPT 
 WHERE 1 = 2   
 
SELECT * 
  FROM DEPTO2;

INSERT INTO DEPTO2
SELECT * FROM DEPT ;

SELECT *
FROM BOOK

