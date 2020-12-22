<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="makeList.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 리스트</h1>
	<table border="1">
	<tr>
		<td>lndex</td>
		<td>count</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>사진</td>
	</tr>
	<c:forEach items="${members}" var="member" varStatus="status">
	<tr>
		<td>${status.index }</td>
		<td>${status.count }</td>
		<td>${member.userId }</td>
		<td>${member.password }</td> 
		<td>${member.userName }</td>
		<td>
			<c:out value="${member.userPhoto }" escapeXml="false">
				<span style="color: red">no photo</span>
			</c:out>
		</td>
	</tr>	
	</c:forEach>
	</table>
	
	<c:forEach var ="num" begin="1" end="10" step="1">
		${num}<br>
	
	</c:forEach>
</body>
</html>