/*
1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
(5) 박지성이구매한도서의출판사수
*/
SELECT COUNT(B.PUBLISHER)
  FROM CUSTOMER C
        INNER JOIN ORDERS O ON C.CUSTID = O.CUSTID
        INNER JOIN BOOK B ON O.BOOKID = B.BOOKID
 WHERE C.NAME = '박지성';
​/*
(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
*/
SELECT B.BOOKNAME, B.PRICE - O.SALEPRICE
  FROM CUSTOMER C
        INNER JOIN ORDERS O ON C.CUSTID = O.CUSTID
        INNER JOIN BOOK B ON O.BOOKID = B.BOOKID
 WHERE C.NAME = '박지성';
​/*
(7) 박지성이구매하지않은도서의이름
*/
SELECT BOOKNAME
  FROM BOOK
 WHERE BOOKID NOT IN (  SELECT O.BOOKID
                          FROM CUSTOMER C
                                INNER JOIN ORDERS O ON C.CUSTID = O.CUSTID
                         WHERE C.NAME = '박지성' );
;       
​/*
2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
(8) 주문하지않은고객의이름(부속질의사용)
*/
SELECT NAME
 FROM CUSTOMER
WHERE CUSTID NOT IN ( SELECT CUSTID 
                        FROM ORDERS );
​/*
(9) 주문금액의총액과주문의평균금액
*/
SELECT SUM(SALEPRICE), AVG(SALEPRICE)
  FROM ORDERS; 
​/*
(10) 고객의이름과고객별구매액
*/
SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C
        INNER JOIN ORDERS O ON C.CUSTID = O.CUSTID
 GROUP BY C.NAME; 
​/*
(11) 고객의이름과고객이구매한도서목록
*/
SELECT C.NAME, B.BOOKNAME
  FROM CUSTOMER C
        INNER JOIN ORDERS O ON C.CUSTID = O.CUSTID
        INNER JOIN BOOK B ON O.BOOKID = B.BOOKID
 ORDER BY C.NAME ASC;        
​/*
(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
*/
SELECT *
  FROM BOOK B
        INNER JOIN ORDERS O ON B.BOOKID = O.BOOKID
 WHERE B.PRICE - O.SALEPRICE = ( SELECT MAX(B.PRICE - O.SALEPRICE)
                                   FROM BOOK B
                                        INNER JOIN ORDERS O ON B.BOOKID = O.BOOKID );

​/*
(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
*/
SELECT C.NAME 
  FROM ORDERS O 
        INNER JOIN CUSTOMER C ON O.CUSTID = C.CUSTID
 GROUP BY C.NAME 
HAVING AVG(O.SALEPRICE) > ( SELECT AVG(SALEPRICE)
                            FROM ORDERS );
​/*

3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
*/
SELECT C.NAME
  FROM ORDERS O 
        INNER JOIN CUSTOMER C ON O.CUSTID = C.CUSTID
        INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
 WHERE B.PUBLISHER IN ( SELECT B.PUBLISHER
                          FROM ORDERS O
                                INNER JOIN CUSTOMER C ON O.CUSTID = C.CUSTID
                                INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
                         WHERE C.NAME = '박지성' ) 
   AND C.NAME <> '박지성';
​/*
(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
*/
SELECT C.NAME
  FROM ORDERS O 
        INNER JOIN CUSTOMER C ON O.CUSTID = C.CUSTID
        INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
 GROUP BY C.NAME
 HAVING COUNT(DISTINCT B.PUBLISHER) > 1
 