<%@page import="member.service.MemberLoginService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberLoginService service = MemberLoginService.getInstance();
	service.memberLogin(request, response);
%>
<jsp:forward page="loginView.jsp"></jsp:forward>

