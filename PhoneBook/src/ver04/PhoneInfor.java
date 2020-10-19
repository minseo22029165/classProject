package ver04;

public class PhoneInfor {
	/*
		Project : ver 0.40
		다음 두 클래스를 추가로 삽입. 상속 구조가 가능하다면 상속 구조로 구성 해보세요.
		PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가
		각 클래스에 정의되어야 하는 인스턴스 변수.
		Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가해 보자
	*/
	// 변수 설정 
	private String name;   // 이름 
	private String phoneNumber; // 전화번호
	private String address; // 주소
	private String email; // 이메일
	
	// 생성자를 통해서 인스턴스 변수들을 초기화 
	public PhoneInfor(String name, String phoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	// getter 메소드 
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	// 오버라이딩 처리할 예정 : 상속하는 클래스의 추가 속성을 출력
	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + address);
		System.out.println("메일 : " + email);
	}


}
