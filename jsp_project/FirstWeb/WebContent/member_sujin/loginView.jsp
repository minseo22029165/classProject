<%@page import="form.loginFormData_sujin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 리퀘스트 데이터 가져오기 
	loginFormData_sujin requestData = (loginFormData_sujin)request.getAttribute("requestData");
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
             	<%=requestData.getUserId() %>
            </td>
        </tr>
        <tr>
            <th><label for="pw">비밀번호</label></th>
            <td>
            	<%=requestData.getUserPw() %>
            </td>
        </tr>
    </table>
	<h3><a href="loginSessionCheck.jsp">로그인 여부 체크 페이지</a></h3>

</body>

</html>