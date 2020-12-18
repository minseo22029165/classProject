<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 모든 java api 사용 가능 
	Connection conn = null;

	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. db 연결 
	String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
	String user = "aia";
	String password = "aia";

	conn = DriverManager.getConnection(jdbcUrl, user, password); 
	
	//out.println("<h1>mysql연결</h1>");
	
	// statement
	Statement stmt = conn.createStatement();
	
	// sql 
	String sql_Dept = "select * from dept";
	
	// 결과받음
	ResultSet rs = stmt.executeQuery(sql_Dept);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mysql connection</title>
</head>
<body>
	<h1>부서리스트</h1>
	<table>
	<tr>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>위치</th>
	</tr>
<%

	while(rs.next()){

%>	
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
	</tr>	
<%
	}

	rs.close();
	stmt.close();
	conn.close();
%>	
	</table>
</body>
</html>