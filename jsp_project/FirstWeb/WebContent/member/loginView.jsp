<%@page import="form.loginFormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 저장 데이터 가져오기 
	loginFormData formData = (loginFormData)request.getAttribute("loginData");
%>    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 뷰</title>
</head>

<body>
    <h1>회원 로그인 뷰</h1>
    <hr>
    
    <table>
        <tr>
            <th><label for="userid">아이디</label></th>
            <td>
                <%=formData.getUserId()%>
            </td>
        </tr>
        <tr>
            <th><label for="pw">비밀번호</label></th>
            <td>
                <%=formData.getUserPw() %>
            </td>
        </tr>
    </table>


</body>

</html>