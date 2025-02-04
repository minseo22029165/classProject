package first;

public abstract class Player {
	
	// 추상클래스 : 클래스의 멤버 메서드들 중 하나라도 추상메서드를 가지면 추상클래스가 된다. 
	// 추상 메서드 
	// 구현하는 {} 구현부가 없는 메서드 
	// 메서드의 정의부에 abstract 키워드는 써준다.
	// 문장 마지막에서 ; 으로 종료 
	abstract void play(int num);
	
	abstract void stop();
	
	
	abstract class VideoPlayer extends Player{
		// 추상 클래스를 상속해서 추상메서드 plyer, stop를 가진다. 
		// VideoPlayer 클래스도 추상클래스다. 
	}
	
	class AudioPlayer extends Player{
		
		// 추상클래스(상위 클래스)의 void play(int num)메서드를 오버라이딩 : 구현한다 
		void play(int num) {};
		void stop() {};
		
	}
	

}
