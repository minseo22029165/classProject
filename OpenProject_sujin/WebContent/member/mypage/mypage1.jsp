<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/loginCheck.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/default.jsp" %>
</head>
<body >

	<%@ include file="/include/header.jsp"  %>
		
	<%@ include file="/include/nav.jsp"  %>
	
	<div class="contents">
		<h2 class="content_title">mypage1</h2>
		<hr>
		<div class="content">
		${loginInfo}	
		<c:if test="${loginInfo ne null}">	
		<img src="${url_root}images/${loginInfo.memberPhoto}" style="width:150px">
		</c:if>
		</div>
	</div>
	
	<%@ include file="/include/footer.jsp" %>

	
	
	
	
	
	
	
	
	


</body>
</html>