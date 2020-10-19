package productStudy;

public class Buyer {
	private int myMoney;
	private int myBonusPoint;
	
	// 구매목록
	Product[] cart = new Product[10]; 
	// 구매갯수
	int count = 0;
	// 총액
	int sum = 0; 
	
	// 생성자
	Buyer(){
		this(1000);
	}

	Buyer(int money){
		this.myMoney = money;
		this.myBonusPoint = 0;
	}
	
	// 구매 처리 
	void buy(Product p) {
		if(myMoney < p.price) {
			System.out.println("돈없어서 못삼");
			return;
		}
		
		myMoney -= p.price;
		myBonusPoint += p.bonusPoint;
		cart[count] = p;
		System.out.println(p);
		count++;
	}
	
	
	// 출력 
	void showData() {
		System.out.println("구매목록------------");
		for(int i=0; i<count; i++) {
			sum += cart[i].price;
		}
		System.out.println("총 구매금액 : " + sum);
		System.out.println("남은돈 : " + myMoney);
		System.out.println("보너스 총액 : " + myBonusPoint);
	}

}
