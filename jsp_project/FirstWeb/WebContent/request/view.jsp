<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import ="form.FormData" %>
 <%
 	FormData data = (FormData)request.getAttribute("data");
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원의 작성 데이터 출력(beans)</title>
</head>
<body>
	<h1>회원의 작성 데이터 출력(beans)</h1>
	<table>
	<tr>
		<td>이름</td>
		<td><%=data.getName()%></td>
	</tr>
	<tr>
		<td>직업</td>
		<td><%=data.getJob()%></td>
	</tr>
	<tr>
		<td>관심사항</td>
		<td>
<%
		for(int i=0; i<data.getInterest().length; i++)
		{
			out.println(data.getInterest()[i] + "<br>");
		}
%>		
		
		</td>
	</tr>		
	</table>
</body>
</html>