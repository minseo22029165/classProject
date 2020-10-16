package product;

public class Buyer { // 자동으로 object 클래스를 상속한다. 
	
	private int money;
	private int bonusPoint;
	
	// 구매한 제품을 담을 배열을 생성 
//	Tv[] tv;
//	Computer[] com;
//	Audio[] audio;
	Product[] cart = new Product[10]; // 이렇게 해주면 된다.10개까지 살수있게
	
	// 구매한 제품의 개수
	int cnt = 0;
	
	// 생성자
	public Buyer() {
		this(1000);
	}
	
	// 생성자 오버로딩 
	public Buyer(int money) {
		this.money = money;
		this.bonusPoint = 0;
	}
	
	void buy(Product p) {
		// 보유한 돈과 제품의 가격을 비교해서 구매여부 판단 
		if(money<p.price) {
			System.out.println("보유한 돈이 부족해서 구매할 수 없습니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		
		// 카드에 제품을 넣는다.
		cart[cnt++] = p;
		
		System.out.println(p + "를 구입했습니다.");

		
	}
	
	void showData() {
		// 구매목룍 출력, 구매 총액 
		int sum = 0;
		
		System.out.println("구매목록 ----------------");
		for(int i=0; i<cnt ; i++) {
			System.out.println(cart[i]);
			sum += cart[i].price;
		}
		System.out.println("----------------------");
		System.out.println("총 구매금액 : " + sum);
		System.out.println("남은돈 : " + money);
		System.out.println("보너스포인트 :" + bonusPoint);
		
	}

}
