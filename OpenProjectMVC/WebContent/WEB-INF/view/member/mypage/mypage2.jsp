<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@include file="/include/loginCheck.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="styleSheet" href="${pageContext.request.contextPath}/css/default.css"> --%>
<link rel="styleSheet" href="${url_defaultCss}">
<style>
</style>
</head>
<body >


	<%@ include file="/WEB-INF/view/include/header.jsp"  %>
		
	<%@ include file="/WEB-INF/view/include/nav.jsp"  %>
	
	<div class="contents">
		<h2 class="content_title">mypage2</h2>
		<hr>
		<div class="content">
		<%--<%=session.getAttribute("loginInfo") --%>
		${loginInfo}
		</div>
	</div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>

	
	
	
	
	
	
	
	
	


</body>
</html>