package phone;

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
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, null);
	}
	
	// 사용자 정보 출력
	void PersonInfo() {
		System.out.print("[이름 : " + name + ", ");
		System.out.print("전화번호 : " + phoneNumber + ", ");
		if(birthday == null) {
			System.out.println("생일 : 입력 데이터 없음]");
		} else {
			System.out.println("생일 : " + birthday + "]");
		}	
	}
	
}
