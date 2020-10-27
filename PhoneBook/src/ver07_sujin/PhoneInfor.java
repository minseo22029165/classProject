package ver07_sujin;

public abstract class PhoneInfor implements Infor {
	
	// 친구의 이름, 전화번호, 주소, 이메일
	// 캡슐화 : 정보은닉(변수의 직접 접근을 제한 - 변수를 보호)
	private String name; 
	private String phoneNum;
	private String addr;
	private String email;
	
	public PhoneInfor(String name, String phoneNum, String addr, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// 정보 출력 기능 (public : 변수는 직접 접근을 하지 못하도록 하지만 외부에서 메서드는 직접 접근 해야하므로 )
	// 하위 클래스에서 오버라이딩 하는 목적 
	@Override
	public void showInfo() {
		System.out.println("이름  : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("주소 : " + addr);
		System.out.println("이메일 : " + email);
		
	}
	
	// 추상 메서드 void showBasicInfor()를 멤버로 가진다. 

}
