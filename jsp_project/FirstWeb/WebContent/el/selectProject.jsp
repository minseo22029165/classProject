<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1. 선택한 상품 : ${param.sel } <br>
	2. 상품설명 : ${product.display }  --> product.getDisplay()
	2. 상품 : ${product.productList[0] } <br>
</body>
</html>