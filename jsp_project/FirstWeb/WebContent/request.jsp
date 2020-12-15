<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 요청오고 사용자가 응답 받았을때 까지가 생명주기 
	request.setAttribute("userName", "손흥민");

	// 프로그램이 시작될때 만들어져서 프로그램이 종료될때까지감 (많이사용x)
	application.setAttribute("userId", "son");

	// 사용자가 처음으로 들어왔을때부터 특정 설정한 시간동안
	session.setAttribute("nickName", "dittosj");
	
	// 페이지가 요청이 될때 (많이사용x)
	pageContext.setAttribute("age", 38);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("userName")%><br>
	<%=application.getAttribute("userId")%><br>
	<%=session.getAttribute("nickName")%><br>
	<%=pageContext.getAttribute("age")%><br>
</body>
</html>