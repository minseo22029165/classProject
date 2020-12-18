<%@page import="util.CookieBox"%>
<%@page import="form.loginFormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userid");
	String userPw = request.getParameter("pw");
	String chk = request.getParameter("chk");
	
	//System.out.println( chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty() );
	
	if(chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty()){
		
		// 쿠키 생성 저장
		// uid = userId
		//System.out.println( userId );
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
		
	} else {
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
	}
	
	// session 추가
	// id, pw 비교해서 같으면 로그인 성공, 다르면 실패
	boolean loginChk = false;
	
	if(userId.equals(userPw)){
		// 로그인 처리		
		loginFormData loginData = new loginFormData();
		
		loginData.setUserId(userId);
		loginData.setUserPw(userPw);
		
		request.setAttribute("loginData", loginData);	
		
		// 로그인 정보를 세션 객체의 속성에 저장 
		session.setAttribute("loginInfo", loginData);
		
		loginChk = true;
	}else {
		// 로그인 실패
		
	}
	
	if (loginChk){
%>
<jsp:forward page="loginView.jsp"></jsp:forward>
<%
	} else {
%>
<script>
	alert("아이디 또는 비밀번호가 틀립니다.");
	history.go(-1);
</script>
<%
	}
%>