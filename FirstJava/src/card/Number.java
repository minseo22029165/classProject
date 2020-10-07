package card;

public class Number {
	
	int num;
	
	// 생성자
	Number(int number){
		num = number;
		System.out.println("생성자가 실행되었습니다.");
	}
	
	// 생성자 2 
	Number() {
		num = 10;
		System.out.println("생성자2 가 실행되었습니다.");
	}
	int getNumber() {
		return num;
	}

}
