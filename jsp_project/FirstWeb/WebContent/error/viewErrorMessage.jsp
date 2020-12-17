<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오류가 발생했습니다.</h1>
	에러 타입: <%= exception.getClass().getName() %> <br>
	에러 메시지: <b><%= exception.getMessage() %></b><br>
	<a href="../index.jsp">인덱스로 이동</a>
</body>
</html>