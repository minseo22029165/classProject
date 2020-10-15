package first;

public class Singletone {
	
	// 싱글톤 패턴 : 인스턴스의 생성을 한번만 하도록 처리하는 코드 작성 스타일 
	// 싱글톤이 필요한 클래스는 : 기능만 있는클랫의 경우 여러개의 인스턴스를 생성할 필요가 없다
	// 기능만 가진 클래스의 경우 실글톤 패턴을 사용
	
	// 1. 외부 인스턴스에서 인스턴스를 생성하지 못하도록 처리 : 생성자에 private 접근 제어자 사용
	private Singletone() {
		
	}
	
	// 2. 사용할 인스턴스를 클래스 내부에서 생성 
	private static Singletone s = new Singletone(); // private를 사용하여 외부의 직접 접근을 막는다 
	
	// 3. 외부에서 만들어진 참조값을 사용할 수 있도록 참조값을 제공하는 메서드 
	public static Singletone getInstance() {
		if(s==null) { //Singletone 인스턴스가 안만들어진 경우
			s = new Singletone();
		}
		return s;
	} 

}
