<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 속성을 따로 저장하지않으면 속성은 scope="page" -->
	<c:set var="msg" value="user1" />
	msg : ${msg } <br>
	
	<c:if test="${msg == 'user1'}" var="result">
		result : ${result } <br>
	</c:if>
	
	<!-- eq : equal ne : not equal  -->
	<c:if test="${msg ne 'user1'}" var="result">
		result : ${result } <br>
	</c:if>	
	
	<c:set var="number" value="12" />
	<c:choose >
		<c:when test="${number>0}">
		양수입니다.
		</c:when>
		<c:when test="${number<0}">
		정수입니다.
		</c:when>
		<c:otherwise>
		0입니다.
		</c:otherwise>
	</c:choose>
	 <br>
	id 저장 <input type="checkbox" ${cookie.uid ne null ? ' checked':''}>
	
</body>
</html>