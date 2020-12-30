<%@page import="member.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<%
	//LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
%>
<c:if test="${not loginChk}">
<script>
	alert("아이디 또는 비밀번호가 틀립니다.");
	history.go(-1);
</script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="styleSheet" href="<%= request.getContextPath() %>/css/default.css"> --%>
<link rel="styleSheet" href="${url_defaultCss}">
<style>
</style>
</head>
<body >
	<c:if test="${loginChk}">

	<%@ include file="/WEB-INF/view/include/header.jsp"  %>
		
	<%@ include file="/WEB-INF/view/include/nav.jsp"  %>
	
	<div class="contents">
		<h2 class="content_title">Login</h2>
		<hr>
		<div class="content">
		로그인 되었습니다. <br>
		${ loginInfo}
		</div>
	</div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>

	</c:if>
</body>
</html>