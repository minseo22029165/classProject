package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 : html 생성 후 반환
		// 응답 관련 객체 HttpServletRequest request
		// 컨텐트 타입과 케릭터셋 설정 
		response.setContentType("text/html; charset=UTF-8");
		
		// 응답처리에 사용할 날짜와 시간 데이터
		Date now = new Date();
		
		// html의 응답처리를 위한 스트림 생성 
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>now date</head>");
		writer.println("<body>");
		writer.println("<h1>현재시간 : " + now + "</h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
	}
	
	
	

}
