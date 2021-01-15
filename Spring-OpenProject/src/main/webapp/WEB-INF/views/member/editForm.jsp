<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%-- <link rel="styleSheet" href="${pageContext.request.contextPath}/css/default.css"> --%>
<%@ include file="/WEB-INF/views/include/basicset.jsp"  %>
<style>
</style>
</head>
<body>


	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<div class="contents">
		<h2 class="content_title">회원 가입 폼</h2>
		<hr>
		<div class="content">
			<form method="post" enctype="multipart/form-data">
				<input type="hidden" id="idx" name="idx" value="${member.idx}">
				<table>
					<tr>
						<th><label for="userid">아이디(email)</label></th>
						<td><input type="email" id="userid" name="userid" value="${member.memberid}" readonly></td>
					</tr>
					<tr>
						<th><label for="pw">비밀번호</label></th>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
					<tr>
						<th><label for="username">이름</label></th>
						<td><input type="text" id="username" name="username" value="${member.membername}">
						</td>
					</tr>
					<tr>
						<th><label for="oldPhoto">현재 사진</label></th>
						<td>
							<img height="40px" src="<c:url value="/fileupload/member/value=${member.memberphoto}"/>">
							<input type="text" id="oldPhoto" name="oldPhoto" value="${member.memberphoto}">
						</td>
					</tr>
					<tr>
						<th><label for="userPhoto">수정할 사진</label></th>
						<td>
							<input type="file" id="userPhoto" name="userPhoto">
						</td>
					</tr>					
					<tr>
						<th></th>
						<td><input type="submit" value="회원정보수정"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>


</body>
</html>