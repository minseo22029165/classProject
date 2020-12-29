<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav>
		<ul>
			<li> <a href="<c:url value="/"/>">HOME</a>  </li>
			<li> <a href="<c:url value="/member/memberRegForm.jsp"/>">회원가입</a>  </li>
			
			<c:if test="${loginInfo eq null}">
			<li> <a href="$<c:url value="/member/loginForm.jsp"/>">LOGIN</a>  </li>
			</c:if>
			
			<c:if test="${loginInfo ne null}">
			<li> <a href="<c:url value="/member/logout.jsp"/>">LOGOUT</a>  </li>
			</c:if>		
	
			<li> <a href="<c:url value="/member/mypage/mypage1.jsp"/>">MYPAGE1</a>  </li>
			<li> <a href="<c:url value="/member/mypage/mypage2.jsp"/>">MYPAGE2</a>  </li>
		</ul>
	</nav>