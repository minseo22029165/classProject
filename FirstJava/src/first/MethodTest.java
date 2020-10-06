package first;

public class MethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyMeth my = new MyMeth();
				
		long num1 = my.add(1, 2);
		System.out.println(num1);
		
		my.sayHello();
		
		my.plus(1, 2);
		
		System.out.println(my.check());
		
		hiEveryone();
		
		my.div(1, 0);
	}
	
	static void hiEveryone() {
		System.out.println("하이");		
	}

}
