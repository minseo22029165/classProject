package card;

public class CardMain {
	
	static int weight = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// static 
		System.out.println(Math.PI);
		System.out.println(CardMain.weight);
			
		System.out.println("카드의 폭 사이즈 : " + Card.width);
		Card.play();
		
		Card c1 = new Card("heart", 10);
		Card c2 = new Card();
		
		System.out.println("카드1의 정보 ");
		System.out.println("모양 :" + c1.kind + ", 숫자 : " + c1.number);
		
		System.out.println("카드2의 정보 ");
		System.out.println("모양 :" + c2.kind + ", 숫자 : " + c2.number);
		
	/*	
		System.out.println("카드의 폭 사이즈 : " + c1.width);
		System.out.println("카드의 폭 사이즈 : " + c2.width);
		
		Card.width = 120;
		
		System.out.println("카드의 폭 사이즈 : " + c1.width);
		System.out.println("카드의 폭 사이즈 : " + c2.width);
	*/	
		c1.play();
		
	}

}
