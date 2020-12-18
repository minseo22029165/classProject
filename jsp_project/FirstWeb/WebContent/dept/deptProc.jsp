<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int no = Integer.parseInt(request.getParameter("no"));
	String name = request.getParameter("name");
	String loc = request.getParameter("loc");
	String div = request.getParameter("div");  // insert : 등록, update : 수정, delete : 삭제

	// 모든 java api 사용 가능 
	Connection conn = null;

	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. db 연결 
	String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
	String user = "aia";
	String password = "aia";

	conn = DriverManager.getConnection(jdbcUrl, user, password); 
	
	// statement
	Statement stmt = conn.createStatement();
	
	// SQL 
	String sqlQuery = "";
	
	if (div == "insert"){
		sqlQuery = "insert into dept(deptno, dname, loc) values (" + no + ", '" + name + "', '" + loc + "')";
	}else if (div == "update"){
		sqlQuery = "update dept set dname = '" + name + "', loc = '" + loc + "' where deptno = " + no;
	}else if (div == "delete"){
		sqlQuery = "delete from dept where deptno = " + no;
	}	
	// statement			
	int resultCnt = stmt.executeUpdate(sqlQuery);
	
	request.setAttribute("result", resultCnt);
	
	stmt.close();
	conn.close();
	
	String comment = "";
	String nextUrl = "";
	
	// 데이터 한행이 정상적으로 삽입된 경우 : 1
	if(resultCnt > 0) {
		comment = "데이터가 정상적으로 " + div + " 되었습니다.";
		nextUrl = "deptView.jsp";
	}else {
		comment = "데이터 저장에 실패하였습니다.";
		nextUrl = "deptList.jsp";
	}
%>
<script>
	alert(<%=comment%>);
	location.href = <%=nextUrl%>;
</script>
