<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
회원가입

회원가입 폼 
-> 회원 데이터를 beans 객체에 저장하고 request 내장객체의 속성에 저장
-> view jsp 페이지로 forwad
 -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 폼</title>
</head>

<body>
    <h1>회원 가입</h1>
    <hr>
    <form action="regResult.jsp" method="get">
        <table>
            <tr>
                <th><label for="userid">아이디(email)</label></th>
                <td>
                    <input type="email" id="userid" name="userid">
                </td>
            </tr>
            <tr>
                <th><label for="pw">비밀번호</label></th>
                <td>
                    <input type="password" id="pw" name="pw"> 
                </td>
            </tr>
            <tr>
                <th><label for="username">이름</label></th>
                <td>
                    <input type="text" id="username" name="username">
                </td>
            </tr>
            <tr>
                <th><label for="userPhoto">사진</label></th>
                <td>
                    <!-- <input type="file" id="userPhoto" name="userPhoto"> -->
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>
    
</body>
</html>