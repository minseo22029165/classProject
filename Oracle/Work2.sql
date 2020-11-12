/*
1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
(1) 도서번호가1인도서의이름
*/
SELECT bookname
  FROM Book
 WHERE bookid = 1;
/*
(2) 가격이20,000원이상인도서의이름
*/
SELECT bookname
  FROM Book
 WHERE price >= 20000;
/*
(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
*/
SELECT SUM(saleprice)
  FROM Orders
 WHERE custid = 1;
/*
(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
*/
SELECT COUNT(*)
  FROM Orders
 WHERE custid = 1; 
/*
​
2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
(1) 마당서점도서의총개수
*/
SELECT COUNT(*)
  FROM Book; 
/*
(2) 마당서점에도서를출고하는출판사의총개수
*/
SELECT COUNT(DISTINCT publisher)
  FROM Book; 
/*
(3) 모든고객의이름, 주소
*/
SELECT name, address
  FROM Customer; 
/*
(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
*/
SELECT orderid 
  FROM Orders
 WHERE orderdate >= '14/07/04' AND orderdate <= '14/07/07'; 
/*
(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
*/
SELECT orderid 
  FROM Orders
 WHERE NOT(orderdate >= '14/07/04' AND orderdate <= '14/07/07'); 
/*
(6) 성이‘김’씨인고객의이름과주소
*/
SELECT name, address
  FROM Customer
 WHERE NAME LIKE '김%'; 
/*
(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
*/
SELECT name, address
  FROM Customer
 WHERE NAME LIKE '김%아'; 
