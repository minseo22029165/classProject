package fruitNew;

public class FruitSalesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 생성자 초기 선언
		FruitSeller seller1 = new FruitSeller(0, 30, 1500);
		FruitSeller seller2 = new FruitSeller(0, 20, 1000);

		FruitBuyer buyer = new FruitBuyer(10000);
		
		buyer.buyApple(seller1, 4500);
		buyer.buyApple(seller2, 2000);
		
		System.out.println("과일판매자1 현재상황");
		seller1.showSaleResult();
		
		System.out.println("과일판매자2 현재상황");
		seller2.showSaleResult();
		
		System.out.println("과일구매자 현재상황");
		buyer.showBuyResult();
		
	}

}
