<%@page import="form.FormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 사용자로부터 받은 데이터를 beans 에 저장하고
	FormData formData = new FormData();
	
	// view.js로 beans 객체를 전달
	String userName = request.getParameter("userName");
	String job = request.getParameter("job");
	String[] interest = request.getParameterValues("interest");
	
	// beans에 데이터를 저장 
	formData.setName(userName);
	formData.setJob(job);
	formData.setInterest(interest);
	
	// view.js로 beans 객체를 전달(공유)
	request.setAttribute("data", formData);
	
%>
<jsp:forward page="view.jsp"/>