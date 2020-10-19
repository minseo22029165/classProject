package productStudy;

public class ProductMain {
	public static void main(String[] args) {
		Buyer buy = new Buyer();
		
		Audio audio = new Audio(10);
		Computer com = new Computer(20);
		Tv tv = new Tv(30);
		
		buy.buy(tv);
		buy.buy(com);
		buy.buy(tv);
		
		buy.showData();
	
	}
}
