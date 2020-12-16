<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크리스 마스 선물 선택폼</title>
</head>
<body>
	<h1>크리스 마스 선물 선택폼</h1>
	<hr>

	<table>
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("userName") %></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<%=request.getParameter("sex") %>
		</td>
	</tr>	
	<tr>
		<td>받고싶은 선물</td>
		<td>
			<%
				String[] presents = request.getParameterValues("present");
				for(int i = 0 ; i < presents.length; i++){
					out.println(presents[i] + "<br>");
				}
			
			
			%>
		</td>
	</tr>				
	</table>


</body>
</html>