package friend;

public class Friend {
	private String name; 
	private String phoneNumber;
	private String addr;
	
	// 생성자를 통해서 인스턴스 변수들을 초기화 
	public Friend(String name, String pNum, String addr) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.phoneNumber = pNum;
		this.addr = addr;
		
	}
	
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddr() {
		return addr;
	}

	// 오버라이딩 처리할 예정 : 상속하는 클래스의 추가 속성을 출력
	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNumber);
		System.out.println("주소 : " + addr);		
	}
	
	// 오버라이딩 :비어있는 처리부를 기능을 추가 
	public void showBasicInfo() { }

}
