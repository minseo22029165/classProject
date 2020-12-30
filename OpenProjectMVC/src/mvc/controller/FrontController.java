package mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.Command;

public class FrontController extends HttpServlet{

	// Map<String, Command> -> 요청경로, Command클래스를 상속하는 객체
	private Map<String, Command> commands;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		commands = new HashMap<String, Command>();
//		commands.put("/", new GreetingCommand());
//		commands.put("/greeting", new GreetingCommand());
//		commands.put("/date", new DateCommand());
//		commands.put("/member/login", new MemberLoginCommand());
		
		commands = new HashMap<String, Command>();
		
		String configPath = config.getInitParameter("configPath");
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		// 설정파일의 시스템의 실제 경로 
		String configFilepath = config.getServletContext().getRealPath(configPath);
		
		try {
			fis = new FileInputStream(configFilepath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//  (Iterator) prop.keySet() --> map을 set으로 바꿔줌
		Iterator itr = prop.keySet().iterator();
		while(itr.hasNext()) {
			String command = (String) itr.next();
			String className = prop.getProperty(command);
			
			
			
			// command Map -> command, className 의 인스턴스를 저장 
			try {
				Class commandClass = Class.forName(className);
				// command 인스턴스 생성 
				Command commandInstance = (Command) commandClass.newInstance();
				
				// command.put(경로, Command 인스턴스)
				commands.put(command, commandInstance);
				
				System.out.println(command + " = " + className);				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		// 요청을 분석 : uri이용해서 분석
		// http://localhost:8080/mbc/gretting --> /gretting 
		String command = request.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(request.getContextPath()));
		
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		System.out.println(command);
		
		// 요청에 맞는 기능 실행 -> 결과데이터 생성
		// Object resultObj = null;
		
		Command cmd = commands.get(command);
		if(cmd == null) {
			cmd = null;
		}
		
		String viewPage = null;
		
//		if(command.equals("/greeting") | command.equals("/")) {
//			cmd = new GreetingCommand();
//		}else if(command.equals("/date")) {	
//			cmd = new DateCommand();
//		}else if(command.equals("/member/login")) {	
//			cmd = new MemberLoginCommand();
//		}else {
//			cmd = new InvalidCommand();
//		}
		
		viewPage = cmd.getViewPage(request, response);
		// request 속성의 결과 데이터를 저장
		// request.setAttribute("result", resultObj);
		
		// 응답페이지 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
