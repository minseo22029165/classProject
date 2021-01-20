<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입폼</h1>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- 	<form method="post" > -->
<!-- 		아이디 <input type="text" name="memberid" id="memberid"><br> -->
<!-- 		비밀번호 <input type="password" name="password" id="password"><br> -->
<!-- 		이름 : <input type="text" name="membername" id="membername"><br> -->
<!-- 		<input type="submit"> -->
<!-- 	</form> -->
		
	<!-- Rest Ajax 사용목적으로 코드 수정  -->
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<form id="regForm">
		아이디 <input type="text" name="memberid" id="memberid"><br>
		비밀번호 <input type="password" name="password" id="password"><br>
		이름 : <input type="text" name="membername" id="membername"><br>
		<input type="submit">
	</form>
	<script>
		$('#regForm').submit(function(){
			var data = {
				memberid : $('#memberid').val(),
				password : $('#password').val(),
				membername : $('#membername').val(),
			};
			

			$.ajax({
				url : '/firstspring/rest/ver1/members',
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=UTF-8',
				//dataType : 'json',
				async : false, 
				success : function(msg){
					if(msg == 'Y'){
						alert('회원 가입이 정상적으로 처리 되었습니다.' + msg);
					}else {
						alert('오류가 발생했습니다. 다시 시도해주세요.' + msg);
					}
				}, 
				error : function(err){
					console.log(err);
				} 				
			});
			
			return false;
		});
	
	</script>
	
</body>
</html>