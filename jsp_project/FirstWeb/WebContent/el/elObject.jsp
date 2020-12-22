<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("userName","dittosj_request");
	session.setAttribute("userName","dittosj_session");
	application.setAttribute("userName","dittosj_application");
	session.setAttribute("userId", "dltnwls3198");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
	requestScope.userName : ${requestScope.userName } --> ${userName }<br>
	sessionScope.userId : ${sessionScope.userId }--> ${userId }<br>
	param.code(request.getParameter("code")) : ${param.code}<br>
	pageContext(pageContext.getRequest().getServlectContext().getContextPath()) : <br>
	<br>${pageContext.request.requestURI} 
	<br>${pageContext.request.requestURL} 
	<br>${pageContext.request.contextPath} 
	</h1>
	<a href="view1.jsp">session 페이지 확인</a>
</body>
</html>