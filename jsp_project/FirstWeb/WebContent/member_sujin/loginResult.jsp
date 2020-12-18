<%@page import="form.loginFormData_sujin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 파라미터
	String userId = request.getParameter("userid");
	String userPw = request.getParameter("pw");
	String idChk = request.getParameter("chk");
	
	// 아이디랑 비번이 같은 경우 로그인했다고 침 
	if(userId.equals(userPw)){
		// 로그인 상태
		loginFormData_sujin loginData = new loginFormData_sujin();
		
		// 생성자에 데이터 넣기
		loginData.setUserId(userId);
		loginData.setUserPw(userPw);
		loginData.setIdChk(idChk);
		
		// 리퀘스트,세션에 데이터 넣어주기 
		request.setAttribute("requestData", loginData);
		session.setAttribute("sessionData", loginData);
%>
<jsp:forward page="loginView.jsp"></jsp:forward>
<%		
		
	}else {
		// 로그아웃 상태 
%>
<script>
	alert("아이디 또는 비밀번호가 틀립니다.");
	history.go(-1);
</script>
<%		
	}

%>