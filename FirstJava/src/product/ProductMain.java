package product;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(new Product(100).toString());
//		System.out.println(new Tv(100).toString());
		
		// 구매자 인스턴스 생성 
		Buyer b = new Buyer();
		
		String str = "";
		
		// 제품 객체를 생성 
		Tv tv = new Tv(200);    //Product p = new Tv();
		Computer com = new Computer(180);  //Product p = new Computer();
		Audio audio = new Audio(150);  //Product p = new Audio();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		
		b.showData();
	}
	
	

}
