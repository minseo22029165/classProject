<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav>
		<ul><!--        /op --> 
			<li> <a href="<c:url value="/"/>">HOME</a>  </li>
			<li> <a href="<c:url value="/member/memberRegForm.do"/>">회원가입</a>  </li>
			<li>
				<%
					if(session.getAttribute("loginInfo")==null){
				%>		
			 <a href="<c:url value="/member/loginForm.do"/>">LOGIN</a>  
			 <%
					} else {
			 %>
			 <a href="<c:url value="/member/logout.do"/>">LOGOUT</a>
			 <%
					}
			 %>			 
			 </li>
			<li> <a href="<c:url value="/member/mypage/mypage1.do"/>">mypage1</a>  </li>
			<li> <a href="<c:url value="/member/mypage/mypage2.do"/>">mypage2</a>  </li>
			<li> <a href="<c:url value="/member/manager/memberList.do"/>">회원 정보</a>  </li>
			<li> <a href="<c:url value="/member/manager/memberList.jsp"/>">방명록</a>  </li>
		</ul>
	</nav>