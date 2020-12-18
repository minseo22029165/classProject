<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	int no = Integer.parseInt(request.getParameter("no"));
 %>   
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 정보 등록</title>
</head>

<body>
    <h1>부서 정보 등록</h1>
    <hr>
    <form action="insert.jsp" method="get">
    	<input type="hidden" name="div" value="insert">
        <table>
            <tr>
                <th><label for="name">부서번호</label></th>
                <td>
                    <input type="number" id="no" name="no" value=<%=no%>>
                </td>
            </tr>
            <tr>
                <th><label for="name">부서이름</label></th>
                <td>
                    <input type="text" id="name" name="name" value=<%=name%>>
                </td>
            </tr>            
            <tr>
                <th><label for="loc">부서위치</label></th>
                <td>
                    <input type="text" id="loc" name="loc" value=<%=loc%>>
                </td>
            </tr>
			<tr>              
                <td>
                <input type="submit" value="저장">
                </td>
            </tr>
        </table>
    </form>

</body>

</html>