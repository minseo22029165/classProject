<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크리스 마스 선물 선택폼</title>
</head>
<body>
	<h1>크리스 마스 선물 선택폼</h1>
	<hr>
	<form action="work1Result.jsp" method="get">
		<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" id="userName"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<select name="sex">
					<option value="여아">여아</option>
					<option value="남아">남아</option>				
				</select>
			</td>
		</tr>	
		<tr>
			<td>받고싶은 선물</td>
			<td>
				<input type="checkbox" name="present" value="인형">인형<br>
				<input type="checkbox" name="present" value="팽이">팽이<br>
				<input type="checkbox" name="present" value="공룡">공룡<br>
				<input type="checkbox" name="present" value="책">책
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="보내기"> <input type="reset" value="초기화">
			</td>
		</tr>				
		</table>
	</form>

</body>
</html>