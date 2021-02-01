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
		
					for(var i = 0 ; i < data.saleList.length; i++) {
						var html = '<a href="javascript:fnViewInfo(' + data.saleList[i].saleNo + ')">';
							html += '  <div class="row no-gutters">';
							html += '  <div class="row no-gutters">';
							html += '    <div class="col-md-4">';
							html += '      <img src="' + data.saleList[i].fileName + '" class="card-img" alt="...">';
				  			html += '    </div>';
				  			html += '    <div class="col-md-8">';
				  			html += '      <div class="card-body">';
				  			html += '        <h5 class="card-title">' + data.saleList[i].saleTitle + '</h5>';
				    		html += '        <p class="card-text">' + data.saleList[i].saleAmount + '</p>';
				    		html += '        <p class="card-text">' + data.saleList[i].saleNic + '<small class="text-muted">댓글수 : ' + data.saleList[i].comCnt + ' 조아요수 : ' + data.saleList[i].goodCnt + '</small></p>';
				    		html += '      </div>';
				    		html += '    </div>';
				    		html += '  </div>';
				    		html += '</div>';
				    		html += '</a>';
						
							$('#content').append(html);
						} 	
					
				},
				error : function(e){
					console.log("에러발생 : " + e);
				}
			});
		});
		
		// 구매목록 상세보기 
		function fnViewInfo(idx){
			// 페이지 테그 삭제
			$('#content *').remove();
			
			$.ajax({
				url : 'http://localhost:8080/market/saleinfo?idx=' + idx,
				type : 'GET',
				success : function(data){
					alert(data)
				},
				error : function(e){
					console.log("에러발생 : " + e);
				}
				
				
			});			
		}
	
	</script>    
</body>

</html>