package first;

public class VariableDecl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char char1 = 'a';  
		
		//System.out.println(char1);
		//System.out.println((int)char1);
		
		int i =0;
		boolean check = true;
		while(check) {
			if(i > 5) {
				break;				
			}
			//System.out.println(i);
			i++;			
		}

		// 상수
		final double PI = 3.141592;
		//System.out.println(PI);
		
		long intNum5 = 10000000000L;
		
		char ch3 = 'A';
		int intChNumber = ch3;
		System.out.println(ch3 + "의 유니코드값은 = " + intChNumber);
		
		
		intChNumber += 1;
		System.out.println((char)intChNumber);
		
		// 작은형으로 변환하면 이상한 값이 들어갈 수 있다.
		int intAge = 200;
		System.out.println((byte)intAge);
	}

}
