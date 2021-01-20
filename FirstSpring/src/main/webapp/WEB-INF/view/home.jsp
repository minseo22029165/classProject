<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Index</h1>
	<ui>
		<c:url value="/hello" var="hello"/>
		<!-- prefix(/WEB-INF/view/) + href 경로(hello) + suffix(.jsp) -->
		<li><a href="${hello}">${hello}</a></li>
		
		<c:url value="/member/login" var="login"/>
		<li><a href="${login}">${login}</a></li>
		
		<c:url value="/member/search" var="membersearch"/>
		<li><a href="${membersearch}">${membersearch}</a></li>		
		
		<c:url value="/order/order" var="order"/>
		<li><a href="${order}">${order}</a></li>	
		
		<c:url value="/cookie/make" var="cookieMake"/>
		<li><a href="${cookieMake}">${cookieMake}</a></li>	
		
		<c:url value="/cookie/view" var="cookieView"/>
		<li><a href="${cookieView}">${cookieView}</a></li>		
		
		<c:url value="/header/header" var="header_url"/>
		<li><a href="${header_url}">${header_url}</a></li>
		
		<c:url value="/search/search" var="search"/>
		<li><a href="${search}">${search}</a></li>		
		
		<c:url value="/upload/uploadForm" var="fileupload"/>
		<li><a href="${fileupload}">${fileupload}</a></li>																
		
		<c:url value="/member/list" var="memberList"/>
		<li><a href="${memberList}">${memberList}</a></li>		
		
		<c:url value="/member/reg" var="memberReg"/>
		<li><a href="${memberReg}">${memberReg}</a></li>	
		
		<c:url value="/members/10" var="members"/>
		<li><a href="${members}">${members}</a></li>
		
		<c:url value="/mc/simple" var="simple"/>
		<li><a href="${simple}">${simple}</a></li>			
		
		<c:url value="/message/listXml" var="listXml"/>
		<li><a href="${listXml}">${listXml}</a></li>
		
		<c:url value="/message/listJson" var="listJson"/>
		<li><a href="${listJson}">${listJson}</a></li>		
		
		<c:url value="/rest/ver1/members/1" var="restMember"/>
		<li><a href="${restMember}">${restMember}</a></li>		
		
		<c:url value="/rest/ver1/members/" var="restMemberList"/>
		<li><a href="${restMemberList}">${restMemberList}</a></li>
		
		<c:url value="/rest/ver1/members/map" var="restMemberMap"/>
		<li><a href="${restMemberMap}">${restMemberMap}</a></li>																
																		
	</ui>

</body>
</html>
