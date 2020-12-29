<%@page import="member.service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// MemberRegService(HttpServletRequest request)  -> int 1 or 0
	MemberRegService service = MemberRegService.getInstance();
	service.insertMember(request);
	
%>
<jsp:forward page="memberRegView.jsp" />