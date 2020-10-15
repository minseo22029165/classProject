package first;

public class ExtendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child c1 = new Child();
		Child2 c2 = new Child2("KING");
		GrandChild gc = new GrandChild("손흥민");
		
		System.out.println(c1.getMoney());
		System.out.println(c2.getMoney());
		System.out.println(c2.name);
		System.out.println(gc.getMoney());
		System.out.println(gc.name);
		
	}

}
