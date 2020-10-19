package ver04;

public class PhoneCompanyInfor extends PhoneInfor {
	private String company; // 회사

	// 생성자를 통해 인스턴스 변수 초기화
	public PhoneCompanyInfor(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;
	}

	@Override  
	public void showData() {
		super.showData();
		System.out.println("회사 : " + company); // 회사정보 추가 
	}
}
