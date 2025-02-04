/*
43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
*/
SELECT ENAME, JOB
  FROM EMP 
 WHERE JOB = ( SELECT JOB 
                 FROM EMP 
                WHERE EMPNO = 7788 );
​/*
44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
*/
SELECT ENAME, JOB
  FROM EMP 
 WHERE SAL > ( SELECT SAL 
                 FROM EMP 
                WHERE EMPNO = 7499 );
​/*
45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
*/
SELECT ENAME, JOB, SAL
  FROM EMP 
 WHERE SAL = ( SELECT MIN(SAL) 
                 FROM EMP );
​/*
46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
*/
SELECT JOB, AVG(SAL)
  FROM EMP
 GROUP BY JOB
 HAVING AVG(SAL) = ( SELECT MIN(AVG(SAL)) 
                       FROM EMP 
                      GROUP BY JOB );
​/*
47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
*/
SELECT E1.ENAME, E1.SAL, E1.DEPTNO
FROM EMP E1, ( SELECT DEPTNO, MIN(SAL) AS MINSAL
                 FROM EMP
                GROUP BY DEPTNO ) E2
WHERE E1.DEPTNO = E2.DEPTNO 
  AND E1.SAL = E2.MINSAL
ORDER BY E1.DEPTNO ASC;
​/*
48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
*/
SELECT EMPNO, ENAME, JOB, SAL
  FROM EMP 
 WHERE SAL < (  SELECT MIN(SAL)
                  FROM EMP
                 WHERE JOB = 'ANALYST' )
   AND JOB <> 'ANALYST';            
​/*
49. 부하직원이 없는 사원의 이름을 표시하시오.
*/
SELECT ENAME
  FROM EMP 
 WHERE EMPNO NOT IN ( SELECT NVL(MGR, 0)
                        FROM EMP );
​/*
50. 부하직원이 있는 사원의 이름을 표시하시오.
*/
SELECT ENAME
  FROM EMP 
 WHERE EMPNO IN ( SELECT NVL(MGR, 0)
                    FROM EMP );
​/*
51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
*/
SELECT ENAME, HIREDATE 
  FROM EMP
 WHERE DEPTNO = (   SELECT DEPTNO 
                      FROM EMP 
                     WHERE ENAME = 'BLAKE' )
   AND ENAME <> 'BLAKE';
​/*
52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬하시오.
*/
SELECT EMPNO, ENAME
  FROM EMP 
 WHERE SAL > ( SELECT AVG(SAL) 
                 FROM EMP )
 ORDER BY SAL ASC;
​/*
53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
*/
SELECT EMPNO, ENAME
  FROM EMP 
 WHERE DEPTNO IN ( SELECT DEPTNO 
                     FROM EMP 
                    WHERE ENAME LIKE '%K%' );
​/*
54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
*/
SELECT E.ENAME, E.DEPTNO, E.JOB
  FROM EMP E 
        INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
 WHERE D.LOC = 'DALLAS';
​/*
55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
​*/
SELECT ENAME, SAL
  FROM EMP 
 WHERE MGR = ( SELECT EMPNO 
                 FROM EMP 
                WHERE ENAME = 'KING' );
/*
56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
​*/
SELECT D.DEPTNO, E.ENAME, E.JOB
  FROM EMP E 
        INNER JOIN DEPT D 
            ON E.DEPTNO = D.DEPTNO 
 WHERE D.DNAME = 'RESEARCH';
/*
57. 평균 월급보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원 번호, 이름, 급여를 표시하시오.
​​*/
SELECT EMPNO, ENAME, SAL
  FROM EMP 
 WHERE SAL > ( SELECT AVG(SAL) 
                 FROM EMP )
   AND DEPTNO IN ( SELECT DEPTNO 
                     FROM EMP 
                    WHERE ENAME LIKE '%M%' );
/*
58. 평균급여가 가장 적은 업무를 찾으시오.
​​*/
SELECT JOB, AVG(SAL)
  FROM EMP 
 GROUP BY JOB
 HAVING AVG(SAL) = ( SELECT MIN(AVG(SAL))
                       FROM EMP
                      GROUP BY JOB );
/*
59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
*/
SELECT ENAME
  FROM EMP 
 WHERE DEPTNO IN ( SELECT DEPTNO 
                     FROM EMP 
                    WHERE JOB = 'MANAGER' );