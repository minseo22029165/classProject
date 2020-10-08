package fruit.ver02;

public class FruitBuyer {
	int myMoney;
	int numOfApple;
	
	// 2020.10.08 생성자정의, 변수의 초기화 목적
//	FruitBuyer(int money) {
//		myMoney = money;
//		numOfApple = 0;
//	}
//	
	public FruitBuyer(int myMoney, int numOfApple) {
		this.myMoney = myMoney;		// this -> 자신을 가르키는 참조변수
		this.numOfApple = numOfApple;
	}

	void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;		
	}
	
	void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 개수 : " + numOfApple);		
	}
}
