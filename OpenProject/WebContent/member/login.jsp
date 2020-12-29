<%@page import="member.model.LoginInfo"%>
<%@page import="member.model.Member"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="util.CookieBox"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userid");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("chk");
	
	//System.out.println( chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty() );
	
	if(chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty()){
		
		// 쿠키 생성 저장
		// uid = userId
		//System.out.println( userId );
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
		
	} else {
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
	}
	
	// session 추가
	// id, pw 비교해서 같으면 로그인 성공, 다르면 실패
	boolean loginChk = false;
	
 	MemberDao dao = MemberDao.getInstance();
 	Connection conn = ConnectionProvider.getConnection();
	Member member = dao.selectMemberLogin(conn, userId, pw);
	
	
	if (member != null){
		//System.out.println(member);
		LoginInfo loginIfo = member.toLoginInfo();
		session.setAttribute("loginInfo", loginIfo);
		//System.out.println(loginIfo);
		loginChk = true;
	}
	
	if(loginChk){
%>
<jsp:forward page="loginView.jsp"></jsp:forward>
<%
	} else {
%>
<script>
	alert("아이디 또는 비밀번호가 틀립니다.");
	history.go(-1);
</script>
<%
	}
%>