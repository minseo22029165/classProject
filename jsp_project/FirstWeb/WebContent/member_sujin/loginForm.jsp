<%@page import="form.loginFormData_sujin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
로그인 처리를 구현해주세요.
폼 -> 로그인 처리 ( 분기 : 성공과 실패) -> 로그인 체크 페이지 -> 로그아웃
코드 답글로 올려주세요
 -->
<%
	loginFormData_sujin sessionData = (loginFormData_sujin)session.getAttribute("sessionData"); 

	String saveId = "";
	String saveIdChk = "";
	
	if(sessionData != null && sessionData.getIdChk() != null){
		if(sessionData.getIdChk().equals("on")){
			saveId = sessionData.getUserId();
			saveIdChk = " checked";
		}		
	}
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 폼</title>
</head>

<body>
    <h1>회원 로그인 </h1>
    <hr>
    <form action="loginResult.jsp" method="get">
        <table>
            <tr>
                <th><label for="userid">아이디</label></th>
                <td>
                    <input type="text" id="userid" name="userid" value="<%=saveId%>">
                </td>
            </tr>
            <tr>
                <th><label for="pw">비밀번호</label></th>
                <td>
                    <input type="password" id="pw" name="pw">
                </td>
            </tr>
            <tr>
            	<th></th>
                <td >
                    	<input type ="checkbox" name="chk" value="on" <%=saveIdChk%>> 아이디 저장 
                </td>
			</tr>
			<tr>              
                <td>
                <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>

</body>

</html>