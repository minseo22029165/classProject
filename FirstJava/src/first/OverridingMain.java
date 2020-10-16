package first;

public class OverridingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 상속한 클래스
		BaseEnSpeaker bs = new BaseEnSpeaker();
		//bs.showCurrentState();
		
		// 부모 클래스 
//		Speaker s = new Speaker();
//		s.showCurrentState();
//		
		
		// 다형성 
		// 조상클래스 타입의 참조변수에 자손클래스 타입의 인스턴스를 참조할 수 있는것 
		// 참조변수는 해당 타입의 멤버만 사용하겠다라고 선언 
		Speaker s = new BaseEnSpeaker();
		// 참조변수 s는 volumeRate 변수와 showCurrentState(), setVolume() 만 사용가능
		
		// Speaker 클래스가 가지는 멤버
		s.setVolume(10);

		// BaseEnSpeaker 클래스가 가지는 멤버 
		//s.setBaseRate(20); // Speaker 가 가지고 있는 메소드가 아니라서 오류남
		
		// BaseEnSpeaker 오버라이딩한 메서드 
		s.showCurrentState();
		

	}

}
