package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// interface는 추상 클래스의 일종인데 멤버의 모든 함수가 추상클래스라서 abstract public 생략 가능 
// 만약 추상클래스이면 extends 한개밖에 못하는데 interface 로 하게 되면 extends를 다른것도 할수있어서 interface로 만드는게 좋다.
public interface Command {
	
	// 요청의 처리, 속성에 결과를 저장 , view 페이지의 경로를 반환 
	String getViewPage(HttpServletRequest reqeust, HttpServletResponse response); 

}
