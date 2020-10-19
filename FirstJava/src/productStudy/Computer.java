package productStudy;

public class Computer extends Product {

	public Computer(int price) {
		super(price);
	}
	
	public String toString() {
		return "Computer 구입 가격 : " + price;		
	}	
}
