<%@page import="form.loginFormData_sujin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 데이터 가져오기 
	loginFormData_sujin sessionData = (loginFormData_sujin)session.getAttribute("sessionData");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(sessionData != null){
		out.println("<h1>로그인 상태입니다.</h1>");
		out.println("<h3>" + sessionData + "</h3>");
		out.println("<h3><a href=\"logout.jsp\">로그아웃</a></h3>");
	}else {
		
%>
	<script>
		alert('로그인이 필요한 페이지 입니다.');
		location.href = 'loginForm.jsp';
	</script>
<%		
	}
%>
</body>
</html>