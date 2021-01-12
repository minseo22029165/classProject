<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<h1>로그인 결과</h1>
	<c:if test="${loginView eq null || loginView == '[]'}">
	로그인 실패
	</c:if>
	<c:if test="${loginView ne null}">
	
		<c:forEach items="${loginView}" var="login">
			${login.membername} 로그인 성공 
		</c:forEach>	
	</c:if>
	

<%-- 	<h1>id : ${uid}, pw : ${pw}</h1> --%>
<%-- 	<h1>id : ${userId}, pw : ${userPw}</h1> --%>
<%-- 	<h1>id : ${loginRequest.uid}, pw : ${loginRequest.pw}</h1> --%>

</body>
</html>