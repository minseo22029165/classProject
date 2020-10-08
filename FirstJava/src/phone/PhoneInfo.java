package phone;
/*
	Version 0.1
	회원번호 관리 프로그램.
	PhoneInfor 라는 이름의 클래스를 정의해 보자.
	 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며,
	 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	• 이름 name String
	• 전화번호 phoneNumber String
	• 생년월일 birthday String
	 단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성

*/
public class PhoneInfo {
	String name;  // 이름
	String phoneNumber;  // 전화번호
	String birthday; // 생년월일

	// 생성자 호출 
	PhoneInfo(String name, String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	// 생년월일 없는 생성자 호출 
	PhoneInfo(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;		
	}
	
	// 사용자 정보 출력
	void PersonInfo() {
		if (birthday == null) {
			System.out.println("이름 : " + name + ", 전화번호 : " + phoneNumber);
		} else {
			System.out.println("이름 : " + name + ", 전화번호 : " + phoneNumber + ", 생년월일 : " + birthday);
		}		
	}
	
	public static void main(String[] args) {
		String nm = "";
		String number = "";
		String birth = ""; 
		
		// 사용자 정보 입력 
		PhoneInfo person1 = new PhoneInfo("사람1", "010-1111-1111", "2020-10-07");
		PhoneInfo person2 = new PhoneInfo("사람2", "010-2222-3333");
		
		// 사용자 정보 출력 
		person1.PersonInfo();
		person2.PersonInfo();
	}	
}
