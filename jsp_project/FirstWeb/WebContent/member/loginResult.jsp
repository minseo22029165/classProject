<%@page import="util.CookieBox"%>
<%@page import="form.loginFormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	loginFormData loginData = new loginFormData();

	String userId = request.getParameter("userid");
	String userPw = request.getParameter("pw");
	String chk = request.getParameter("chk");
	
	//System.out.println( chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty() );
	
	if(chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty()){
		
		// 쿠키 생성 저장
		// uid = userId
		//System.out.println( userId );
		
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
		//System.out.println( 2 );
		
	} else {
		//System.out.println( 3 );
		
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
		//System.out.println( 4);
	}

	loginData.setUserId(userId);
	loginData.setUserPw(userPw);
	
	request.setAttribute("loginData", loginData);
%>
<jsp:forward page="loginView.jsp"></jsp:forward>