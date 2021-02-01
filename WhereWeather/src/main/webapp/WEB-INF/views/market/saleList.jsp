<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>+WEATHER WEAR+</title>

<link rel="styleSheet" href="<c:url value="/css/default.css"/>">

<%@ include file="/WEB-INF/views/include/basicset.jsp"%>

</head>

<body bgcolor="#f5f5f5">

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="content" id="content" name="content">
       여기는 콘텐츠 영역입니다 각 페이지 별로 자유롭게 사용하세요~! 
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>

	<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url : 'http://localhost:8080/market/salelist',
				type : 'GET',
				success : function(data){
					alert(JSON.stringify(data));
				
// 					$.each(data, function(index, item){
					
// 						var html = '    <div class="media text-muted pt-3">';
// 							//html += '	<img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">';
// 							html += '  	<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">';
// 							html += '    <strong class="d-block text-gray-dark">' + item.memberid + '(' + item.membername + ')</strong>';
// 							html += '    ' + item.memberphoto;
// 							html += '   </p>';
// 							html += ' </div>';	
							
// 						$('#member_list').append(html);
// 					});						
				},
				error : function(e){
					console.log("에러발생 : " + e);
				}
				
				
			});
			
			
			
		});
	
	</script>    
</body>

</html>