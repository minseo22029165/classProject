package product;

public class Product extends Object {
	int price;
	int bonusPoint;
	
	// 생성자
	public Product(int price) {
		super();
		this.price = price;
		this.bonusPoint = (int)(price*0.1f);
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}

	
	
}
