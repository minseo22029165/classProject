select *
from tab;


desc emp;

SELECT *
  FROM emp 
  ;
  
SELECT *
FROM DEPT;

SELECT comm, NVL(comm, 0) as comm2
FROM emp;

select '이' || '수진'
FROM emp;

SELECT deptno 
FROM emp;


SELECT DISTINCT deptno 
FROM emp;

SELECT *
FROM emp 
WHERE deptno = 10;

SELECT *
  FROM emp
WHERE ename = 'Ford'
    
