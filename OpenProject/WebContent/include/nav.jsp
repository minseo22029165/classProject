<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav>
		<ul><!--        /op -->
			<li> <a href="${pageContext.request.contextPath}">HOME</a>  </li>
			<li> <a href="${pageContext.request.contextPath}/member/memberRegForm.jsp">회원가입</a>  </li>
<%
	if(session.getAttribute("loginInfo") == null){
%>			
			<li> <a href="${pageContext.request.contextPath}/member/loginForm.jsp">LOGIN</a>  </li>
<%
	}else{
%>			
			<li> <a href="${pageContext.request.contextPath}/member/logout.jsp">LOGOUT</a>  </li>
<%
	}
%>			
			<li> <a href="${pageContext.request.contextPath}/member/mypage/mypage1.jsp">MYPAGE1</a>  </li>
			<li> <a href="${pageContext.request.contextPath}/member/mypage/mypage2.jsp">MYPAGE2</a>  </li>
			<li> <a href="#">HOME</a>  </li>
		</ul>
	</nav>