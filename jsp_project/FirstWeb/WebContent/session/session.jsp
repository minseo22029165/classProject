<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	session.setAttribute("userName", "이수진");   
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션에 정보를 저장했습니다.</h1>
	<h1><a href="sessionResult.jsp">세션의 속성 확인</a></h1>
	<h1><a href="../index.jsp">index로 이동</a></h1>
</body>
</html>