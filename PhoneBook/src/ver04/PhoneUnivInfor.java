package ver04;

public class PhoneUnivInfor extends PhoneInfor {
	private String major;  // 전공 
	private String year;   // 학년 
	
	// 생성자를 통해 인스턴스 변수 초기화
	public PhoneUnivInfor(String name, String phoneNumber, String address, String email, String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major; // 전공
		this.year = year; 	// 학년
	}
	
	@Override  
	public void showData() {
		super.showData();
		System.out.println("전공 : " + major); // 전공 추가
		System.out.println("학년 : " + year); // 학년 추가
	}

}
