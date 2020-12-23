<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/loginCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/default.jsp" %>
</head>
<body >

	<%@ include file="/include/header.jsp"  %>
		
	<%@ include file="/include/nav.jsp"  %>
	
	<div class="contents">
		<h2 class="content_title">mypage2</h2>
		<hr>
		<div class="content">
		${loginInfo}
		</div>
	</div>
	
	<%@ include file="/include/footer.jsp" %>

	
	
	
	
	
	
	
	
	


</body>
</html>