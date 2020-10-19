package friend;

public class UnivFriend extends Friend {
	
	private String major;  //친구의 전공 

	public UnivFriend(String name, String pNum, String addr, String major) {
		super(name, pNum, addr);
		this.major = major;
	}

	@Override
	public void showData(){
		super.showData();
		System.out.println("전공 : " + major);
	}
	
	@Override 
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("전화 : " + getPhoneNumber());
		System.out.println("전공 : " + major);	
	}

}
