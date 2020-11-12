SELECT ABS(-15)
FROM DUAL;

SELECT FLOOR(17.1)
FROM DUAL;

SELECT ROUND(17.77777), ROUND(17.77777, 2), TRUNC(17.77777), TRUNC(17.77777, 2)
FROM DUAL;


SELECT LOG(10, 1000), POWER(2, 8)
FROM DUAL;


SELECT CONCAT('나의 이름은 ', ENAME), '나의 이름은 ' || ENAME
FROM EMP;

SELECT LOWER('ABCDEFG'), UPPER('abcdefg')
FROM EMP;

-- **********abcde, abcde**********
SELECT LPAD('830802-2', 15, '*'), RPAD('830802-2', 15, '*')
FROM DUAL;

SELECT SUBSTR('ABCDEFG',3,4), RPAD(SUBSTR('830802-2000000', 1, 8), 14, '*')
FROM DUAL;

SELECT LTRIM('*TRIM*', '*'), LTRIM('         TRIM*', ' ')
FROM DUAL;

SELECT TRIM(' ' FROM '     FROM     ')
FROM DUAL;

SELECT REPLACE('000000-0000000', '-', '')
FROM DUAL;

SELECT SYSDATE, SYSDATE+1, add_months(SYSDATE, 4), last_day(SYSDATE)
FROM DUAL;

SELECT sysdate, to_char(sysdate, 'YYYY.MM.DD day dy am pm hh hh24 mi ss')
FROM DUAL;

SELECT to_char(sysdate, 'YYYY.MM.DD hh24:mi:ss')
FROM DUAL;

-- 숫자 -> 문자
SELECT to_char(10000.123, 'L000,000.000'), to_char(10000.123, 'L999,999.999')
FROM DUAL;

-- L : 원(천만원까지 표현)
SELECT SAL, to_char(SAL*1100,'L00,000,000'), to_char(SAL*1100,'L99,999,999')
FROM EMP;

-- 오늘이 2020-01-01에서 몇일이 지났는지
SELECT TRUNC(SYSDATE - TO_dATE('20-01-01', 'YY-MM-DD'))
FROM DUAL;

-- 내가 몇일을 살았는지
SELECT TRUNC(SYSDATE - TO_dATE('83-08-02', 'YY-MM-DD'))
FROM DUAL;

-- 문자 -> 숫자
SELECT TO_NUMBER('20,000', '99,999.00')
FROM DUAL;

-- DECODE 함수 : SWITCH 문과 비슷하다. 
-- 사원이름, 부서번호, 부서이름 출력 
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATION', 'NULL')
FROM emp;

--8. 직급에 따라 급여를 인상하도록 하자. 직급이 'ANALYST'인 사원은 5%,
--'SALESMAN'인 사원은 10%, 'MANAGER'인 사원은 15%, 'CLERK'인
--사원은 20%인 인상한다. 
SELECT ENAME, JOB, SAL, DECODE(JOB, 'ANALYST', SAL*1.05, 'SALESMAN', SAL*1.1, 'MANAGER', SAL*1.15, 'CLERK', SAL*1.2) AS UPSAL
FROM emp;


SELECT ename, case when deptno = 10 then 'ACCOUNTING' 
                   when deptno = 20 then 'RESEARCH' 
                   when deptno = 30 then 'SALES' 
                   when deptno = 40 then 'OPERATION' 
                   ELSE 'NULL'
              end 
FROM emp;

-- NULL 값은 연산의 대상이 되지 않는다. 
SELECT  COUNT(COMM), COUNT(NVL(COMM, 0))
FROM emp;


SELECT SUM(NVL(COMM, 0)), AVG(NVL(COMM, 0)), COUNT(NVL(COMM, 0)), MAX(COMM), MIN(COMM)
FROM emp

