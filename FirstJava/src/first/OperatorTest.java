package first;

import java.util.Scanner;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 10;
		int num2 = 8;
		float pi = 3.141592f;
		/*
		System.out.println(num1/num2);
		System.out.println(num1/-num2);
		System.out.println(10f/8f);
		System.out.println(10f/8);
		System.out.println(num1/(float)num2);
		
		
		char char1  = 'A';
		char char2  = 'B';
		System.out.println("'A' < 'B' = " + (char1<char2));
		System.out.println("'0'==0 ==>" +('0' == 0));
		System.out.println("10.0d == 10.0f ==>" + (10.0d == 10.0f));
		System.out.println("0.1d == 0.1f ==>" + (0.1d == 0.1f));
		
		double d = 0.1f;
		System.out.println(d);
		
		System.out.println("(float)d == 0.1f ==>" + ((float)1d == 0.1f));
		
		
		num1 = 10;
		num2 = 20;
		boolean result1 = num1 == 10 && num2 == 20;
		boolean result2 = num1 <= 12 || num2 >= 30;
		System.out.println(result1);
		System.out.println(result2);
		
		
		
		float sPi = (int)(pi * 100)/100f;
		System.out.println(sPi);
		
		int price = 11234;  // 100단위까지 절삭하길 원함
		int price2 = price/1000*1000;
		System.out.println(price2);
		
		float sPie2 = Math.round(pi*100)/100f;
		System.out.println(pi*100);
		System.out.println(sPie2);
		
		
		int i = 5;
		int j = 5;
		
		System.out.println(i++);
		System.out.println(++j);
		
		
		// 문자열처리 : string 클래스 이용 -> 객체 생성 -> 클래스가 가지는 변수와 메서드를 메모리에 로드 한다. 
		
		// 참조변수 :객체의 메모리 주소값을 저장하는 변수 
		String str = null;  // null -> 참조변수가 객체의 주소값을 저장하고 있지 않는다. 
		str = "abc";  // 공백 문자열을 이용한 객체를 생성하고 주소값을 반환
		System.out.println(str.toString());
		System.out.println(str.equals("abc"));
		
		if(str != null && !str.equals("")) {
			System.out.println(str.charAt(1));
		}
		
		
		num1 = 50;
		num2 = 20;
		
		int big;   // 큰수
		int diff;  // 두수의 차이
		
		// 삼항 연산자
		//big = (num1 > num2) ? num1 : num2; 
		//diff = (num1 > num2) ? num1 - num2 : num2 - num1;

		if(num1 > num2) {
			big = num1;	
			diff = num1 - num2;			
		} else {
			big = num2;
			diff = num2 - num1;		
		}

		// if로 변경 
		System.out.println(big);
		System.out.println(diff);	
		*/
		
		System.out.println("1: 입력, 2 : 보기, 3: 수정, 4:삭제 중 입력하세요~ ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		switch(n) {
			case 1 :
				System.out.println("1");
				break;
			case 2 :
				System.out.println("2");
				break;
			case 3 :
				System.out.println("3");
				break;
			default : 
				System.out.println("0");
				break;
		
		}
	}

}
