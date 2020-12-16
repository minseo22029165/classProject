<%@page import="form.regFormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 저장 데이터 가져오기 
	regFormData formData = (regFormData)request.getAttribute("regData");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 폼</title>
</head>

<body>
    <h1>회원 가입 뷰</h1>
    <hr>
   
    <table>
        <tr>
            <th><label for="userid">아이디(email)</label></th>
            <td>
                <%=formData.getUserId()%>
            </td>
        </tr>
        <tr>
            <th><label for="pw">비밀번호</label></th>
            <td>
                <%=formData.getUserPw()%>
            </td>
        </tr>
        <tr>
            <th><label for="username">이름</label></th>
            <td>
                <%=formData.getUserName()%>
            </td>
        </tr>
        <tr>
            <th><label for="userPhoto">사진</label></th>
            <td>
                <!-- <input type="file" id="userPhoto" name="userPhoto"> -->
                
            </td>
        </tr>
    </table>

    
</body>
</html>