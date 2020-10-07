package fruitNew;

public class FruitBuyer {
	int myMoney;
	int numOfApple;
	
	// 생성자
	FruitBuyer(int money) {
		myMoney = money;
		numOfApple = 0;
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
