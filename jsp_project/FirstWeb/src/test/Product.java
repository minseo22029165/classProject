package test;

import java.util.Arrays;

// 상품이 가지는 beans형식으로 정의
public class Product {
	private String[] productList = {"item1", "item2", "item3", "item4", "item5"};
	
	//test 
	private int price = 100;
	private int amount = 100;
	
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	public String getDisplay() {
		return "price= " + price + ", amount= " + amount;
		
	}
	@Override
	public String toString() {
		return "Product [productList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
}
