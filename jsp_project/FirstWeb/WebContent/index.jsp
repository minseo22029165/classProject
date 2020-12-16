<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<%
	Date now = new Date();
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX <%=session.getAttribute("userName") %></h1>
	<h1><a href="/FirstWeb/test/now.jsp">절대경로(/FirstWeb/test/now.jsp)</a></h1>
	<h1><a href="test/now.jsp">상대경로(test/now.jsp)</a></h1>
	<h1><a href="test/MsWord.jsp">test/MsWord.jsp</a></h1>
	<h1><a href="request/request_form.jsp">request/request_form.jsp</a></h1>
	<h1><a href="response/selectPage.jsp">response/selectPage.jsp</a></h1>
	<h1><a href="session/session.jsp">session/session.jsp</a></h1>
	<h1><a href="attribute/applicationAttrSet.jsp">attribute/applicationAttrSet.jsp</a></h1>
	<h1><a href="attribute/requestAttrSet.jsp">attribute/requestAttrSet.jsp</a></h1>

</body>
</html>