package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	// 서블릿 객체를 실행할때 처음 한번 실행해 주는 메소드
	// 서블릿은 web.xml 에 등록하고  컨테이너가 실행할때 한번 서블릿이 실행하도록 설정해줌
	@Override
	public void init() throws ServletException {
		
		//드라이버를 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver load sucess");
		} catch (ClassNotFoundException e) {
			System.out.println("driver load fail");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
