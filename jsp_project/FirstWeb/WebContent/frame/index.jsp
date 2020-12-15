<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div.header {
			text-align: center;
		}
		
		div.nav {
			text-align: center;
		}
		
		div.news, div.shopping {
			width : 45%;

		}
		
		div.news{
			float : left;
		}
		
		div.shopping{
			float : right;
		}		
		
		div.footer {
			clear : both;
			text-align: center;
		}
	</style>
</head>
<body>

	<%@ include file = "header.jsp" %>	
	
	<%@ include file = "nav.jsp" %>	
	
	<div class="contents">
		<%@ include file = "news.jsp" %>	
		<%@ include file = "shopping.jsp" %>	
	</div>	
	
	<!-- <%@ include file = "footer.jsp" %> -->	
	<jsp:include page="footer.jsp">
		<jsp:param value="dittosj@gmail.com" name="email"/>
		<jsp:param value="010-8912-1930" name="tel"/> 
	</jsp:include>

</body>
</html>