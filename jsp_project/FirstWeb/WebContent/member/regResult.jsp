<%@page import="form.regFormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	regFormData regData = new regFormData();

	String userId = request.getParameter("userid");
	String userPw = request.getParameter("pw");
	String userName = request.getParameter("username");
	//String userPw = request.getParameter("userPhoto");
	
	regData.setUserId(userId);
	regData.setUserPw(userPw);
	regData.setUserName(userName);
	//regData.setUserPhoto(userPhoto);	
	
	request.setAttribute("regData", regData);
%>
<jsp:forward page="regView.jsp"/>
