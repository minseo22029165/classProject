package friend;

public class HighFriend extends Friend {
	private String work; // 고교 동창의 직업

	// 생성자를 통해 인스턴스 변수 초기화
	public HighFriend(String name, String pNum, String addr, String work) {
		super(name, pNum, addr);
		this.work = work;
	}
	
	@Override 
	public void showData() { // Friend f = new HighFriend() -> f.showData()
		super.showData();
		System.out.println("직업 : " + work);
	}
	
	@Override 
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("전화 : " + getPhoneNumber());
		System.out.println("주소 : " + getAddr());	
	}
	
	

}
