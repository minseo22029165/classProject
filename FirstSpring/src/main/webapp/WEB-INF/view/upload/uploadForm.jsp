<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 : REPORT 제출 </h1>
	<hr>
	<h3>@RequestParam 을 이용한 파일 업로드</h3>
	<form action="upload1" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="sn"><br>
		리포트 파일 : <input type="file" name="report"><br>
		
		<input type="submit"><br>
	</form>
	
	
	<hr>
	<h3>MultipartHttpServletRequest 을 이용한 파일 업로드</h3>
	<form action="upload2" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="sn"><br>
		리포트 파일 : <input type="file" name="report"><br>
		
		<input type="submit"><br>
	</form>

	<hr>
	<h3>커멘드 객체를 이용한 파일 업로드</h3>
	<form action="upload3" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="sn"><br>
		리포트 파일 : <input type="file" name="report"><br>
		
		<input type="submit"><br>
	</form>	
	
</body>
</html>