/*
32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
*/
SELECT D.DEPTNO, D.DNAME
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO 
   AND E.ENAME = 'SCOTT';
​/*
33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
*/
SELECT E.ENAME, D.DNAME, D.LOC
  FROM EMP E 
    INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO;     
​/*
36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
*/
SELECT E.ENAME, D.DNAME
  FROM EMP E 
    INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
 WHERE E.ENAME LIKE '%A%';     
​/*
37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
*/
SELECT E.ENAME, E.JOB, D.DNAME
  FROM EMP E 
    INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
 WHERE D.LOC = 'NEW YORK';
​/*
38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
*/
SELECT E1.ENAME, E1.EMPNO, E2.ENAME
  FROM EMP E1, EMP E2 
 WHERE E1.MGR = E2.EMPNO;
​/*
39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
*/
SELECT E1.ENAME, E1.EMPNO, E2.ENAME
  FROM EMP E1 
    LEFT OUTER JOIN EMP E2 ON E1.MGR = E2.EMPNO
 ORDER BY E1.EMPNO DESC;
​/*
40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
*/
SELECT E1.ENAME, E1.DEPTNO
  FROM EMP E1, EMP E2 
 WHERE E1.DEPTNO = E2.DEPTNO
   AND E2.ENAME = 'SCOTT'
   AND E1.ENAME != 'SCOTT';
​/*
41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
*/
SELECT E1.ENAME, E1.HIREDATE
  FROM EMP E1, EMP E2 
 WHERE E2.ENAME = 'WARD'
   AND E1.HIREDATE > E2.HIREDATE;
​/*
42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
*/
SELECT E1.ENAME AS "사원명", E1.HIREDATE AS "사원입사일", E2.ENAME AS "관리자명", E2.HIREDATE AS "관리자입사일"
  FROM EMP E1, EMP E2 
 WHERE E1.MGR = E2.EMPNO
   AND E1.HIREDATE < E2.HIREDATE;
