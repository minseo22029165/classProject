<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cookieBox = new CookieBox(request);

	String saveId = cookieBox.exists("uid") ? cookieBox.getValue("uid") : "";
	String checked = cookieBox.exists("uid") ? " checked" : "";
%>    
<!-- 
로그인 

로그인 폼 
-> 로그인 데이터를 beans 객체에 저장하고 request 내장객체의 속성에 저장
-> view.jsp 페이지로 forward
 -->

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
                    <!--< input type="text" id="userid" name="userid" value="<%=saveId%>"> -->
                    <input type="text" id="userid" name="userid" value="${cookie.uid.value}">
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
                    	<input type ="checkbox" name="chk" value="on" <%=checked%>> 아이디 저장 
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