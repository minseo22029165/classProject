<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Index</h1>
	<ui>
		<c:url value="/hello" var="hello"/>
		<!-- prefix(/WEB-INF/view/) + href 경로(hello) + suffix(.jsp) -->
		<li><a href="${hello}">${hello}</a></li>
		
		<c:url value="/member/login" var="login"/>
		<li><a href="${login}">${login}</a></li>
		
		<c:url value="/member/search" var="search"/>
		<li><a href="${search}">${search}</a></li>		
		
		<c:url value="/order/order" var="order"/>
		<li><a href="${order}">${order}</a></li>				
	</ui>

</body>
</html>
