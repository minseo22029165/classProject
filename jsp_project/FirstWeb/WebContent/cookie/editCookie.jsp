<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("userId", "dltnwls");
	response.addCookie(cookie);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키의 userId 값이 변경 되었습니다.</h1>
	<h1><a href="viewCookie.jsp">쿠키 정보 확인</a></h1>
</body>
</html>