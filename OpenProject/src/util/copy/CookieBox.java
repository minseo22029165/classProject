package util.copy;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

// 쿠키 객체를 생성하고, 저장하고, 저장된 쿠키를 꺼내 쓰는 기능 
public class CookieBox {
	// cookie 객체를 저장하는 Map 객체를 생성 
	Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	// 초기화 : cookieMap에 Cookie 데이터를 저장
	// 생성자
	public CookieBox(HttpServletRequest request) {
		// request 를 통해 Cookie 정보를 얻을 수 있다.
		Cookie[] cookies = request.getCookies();
		
		if(cookies!= null && cookies.length>0) {
			
			//System.out.print("cookies.length = " + cookies.length);
			for(int i=0; i<cookies.length; i++) {
				//cookieMap에 Cookie 객체를 저장 
				cookieMap.put(cookies[i].getName(), cookies[i]);
				
			}
			
		}
		
		
	}
	
	// 이름으로 쿠키 객체를 반환 
	public Cookie getCookie(String name) {
		return cookieMap.get(name);		
	}
	
	// 이름으로 값을 반환 
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);	 // Map에 name의 키가없는 경우 null로 변환도 가능
		if(cookie==null) {
			return null;
		}
		
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}	
	
	// cookieMap에 특정 이름의 쿠키가 존재하는지 여부 확인 
	public boolean exists(String name) {
		return cookieMap.get(name) != null;		
	}
	
	// 쿠키 객체를 생성해주는 메소드 : 객체를 생성하지 않고도  사용할 수 있는 메소드로 정의 : static 멤버로 정의
	// 이름, 값을 가지고 cookie 객체를 생성
	public static Cookie createCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		return cookie;
		
	}
	
	//이름, 값, 경로, 유지시간을 가지고 cookie 객체를 생성 
	public static Cookie createCookie(String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);  // 보통은 / 로 넣어줌 
		cookie.setMaxAge(maxAge);  // 유지시간 설정 
		
		return cookie;		
	}
	
	//이름, 값, 경로, 유지시간, 도메인을 가지고 cookie 객체를 생성 
	public static Cookie createCookie(String name, String value, String path, int maxAge, String domain) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);  // 보통은 / 로 넣어줌 
		cookie.setMaxAge(maxAge); // 유지시간 설정 
		cookie.setDomain(domain);
		return cookie;		
	}	
}
