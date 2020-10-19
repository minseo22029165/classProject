package ver04;

public class PhoneFamilyInfor extends PhoneInfor {
	private String relationship; // 가족관계 

	// 생성자를 통해 인스턴스 변수 초기화
	public PhoneFamilyInfor(String name, String phoneNumber, String address, String email, String relationship) {
		super(name, phoneNumber, address, email);
		this.relationship = relationship; 
	}

	@Override  
	public void showData() {
		super.showData();
		System.out.println("가족관계 : " + relationship); // 가족관계 추가 
	}
}
