package star;

// interface는 추상메서드와 상수만 표현 가능 
public interface Fightable {
	//public abstract void move();
	//public abstract void attact();
	
	
	// public abstract 생략가능 
	void move();  
	void attact();
	
	//public static final int NUM = 10;
	
	// public static final 생략가능 
	int NUM = 10;
	

}
