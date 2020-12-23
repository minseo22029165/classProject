<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/default.jsp" %>
</head>
<body >
	<%@ include file="/include/header.jsp"  %>
		
	<%@ include file="/include/nav.jsp"  %>
	
	<div class="contents">
		<h2 class="content_title">Login</h2>
		<hr>
		<div class="content">
		로그인 되었습니다. <br>
		${loginInfo}
		</div>
	</div>
	
	<%@ include file="/include/footer.jsp" %>

</body>
</html>