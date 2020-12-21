<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav>
		<ul><!--        /op -->
			<li> <a href="<%= request.getContextPath()%>">HOME</a>  </li>
			<li> <a href="<%= request.getContextPath()%>/member/memberRegForm.jsp">회원가입</a>  </li>
<%
	if(session.getAttribute("loginInfo") == null){
%>			
			<li> <a href="<%= request.getContextPath()%>/member/loginForm.jsp">LOGIN</a>  </li>
<%
	}else{
%>			
			<li> <a href="<%= request.getContextPath()%>/member/logout.jsp">LOGOUT</a>  </li>
<%
	}
%>			
			<li> <a href="<%= request.getContextPath()%>/member/mypage/mypage1.jsp">MYPAGE1</a>  </li>
			<li> <a href="<%= request.getContextPath()%>/member/mypage/mypage2.jsp">MYPAGE2</a>  </li>
			<li> <a href="#">HOME</a>  </li>
		</ul>
	</nav>