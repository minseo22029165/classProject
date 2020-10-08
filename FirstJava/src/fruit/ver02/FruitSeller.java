package fruit.ver02;

/*
 	파일이름 : FruitSeller.java
 	설명 : 사과 장수의 객체를 정의
 	작성일시 :2020.10.08 
 */
public class FruitSeller {
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE;
	
	// 2020.10.08 생성자 추가
	FruitSeller(){
		this(0, 20, 1000);
	}
	
	// 생성자
	FruitSeller(int money, int appleNum, int price){
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price; // 생성자는 final 도 값넣을수 있음		
	}
	
	// 생성자 복사
	FruitSeller(FruitSeller seller){
//		APPLE_PRICE = seller.APPLE_PRICE;
//		numOfApple = seller.numOfApple;
//		myMoney = seller.myMoney;
		
		this(seller.myMoney, seller.numOfApple, seller.APPLE_PRICE);
				
	}
	
	// 사과 판매 
	int saleApple(int money) {
		int num = money / APPLE_PRICE;  // 판매한 사과 개수
		numOfApple -= num; // 남은 사과개수
		myMoney += money; // 수익금
		return num;
	}
	
	void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}

}
