<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
 <c:if test="${loginInfo eq null}">
<script>
	alert('로그인이 필요한 페이지 입니다.');
	location.href = '${url_root}member/loginForm.jsp';
</script>
</c:if>