package first;

public class Work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=300;
		/*	
		아래 예제는 두 개의 if문을 사용하고 있다. 한 개의 if 문만 사용하는 방식으
		로 변경해보자.
		
		if(num>0) {
			if((num%2)==0)
			System.out.println(“양수이면서 짝수");
			}
		}
		
		
		int num=120;
		if(num > 0 && (num%2) == 0) {
			System.out.println("양수이면서 짝수");
		}
		
		문제2.
		다음과 같이 출력이 이루어지도록 작성해보자.
		num < 0 이라면 “0 미만” 출력
		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
		300 ≤ num 이라면 “300이상 “ 출력

		if (num < 0) {
			System.out.println("0 미만");
		}
		else if(num < 100) {
			System.out.println("0이상 100 미만");
		} 
		else if(num < 200) {
			System.out.println("100이상 200 미만");
		} 
		else if(num < 200) {
			System.out.println("200이상 300 미만");
		} else {
			System.out.println("300이상");
		}
		
				
		문제3.
		CondOp.java를 조건연산자(3항 연산자)를 사용하지 않고,
		if~else를 사용하는 형태로 변경해 보자.		
		int num1=50, num2=100;
		int big, diff;
		big = (num1>num2)? num1:num2;
		System.out.println(big);
		diff = (num1>num2)? num1-num2: num2-num1;
		System.out.println(diff);
	
		int num1=50, num2=100;
		int big, diff;
		//big = (num1>num2)? num1:num2;
		if(num1>num2) {
			big = num1;			
		} else {
			big = num2;	
		}
		System.out.println(big);
		
		//diff = (num1>num2)? num1-num2: num2-num1;
		if(num1>num2) {
			diff = num1-num2;			
		} else {
			diff = num2-num1;	
		}	
		System.out.println(diff);
		
		문제 4.
		SwitchBreak.java를 switch문이 아닌, if~else를 사용하는 형태로 변경해 보자.	
		int n=3;
		switch(n) {
			case 1:
				System.out.println("Simple Java");
				break;
			case 2:
				System.out.println("Funny Java");
				break;
			case 3:
				System.out.println("Fantastic Java");
				break;
			default:
				System.out.println("The best programming language");
		}
		System.out.println("Do you like coffee?");
		
		
		int n=3;
		if (n == 1) {
			System.out.println("Simple Java");			
		}
		else if (n == 2) {
			System.out.println("Funny Java");
		}
		else if (n == 3) {
			System.out.println("Fantastic Java");
		}else {
			System.out.println("The best programming language");
		}
		System.out.println("Do you like coffee?");
		
		문제 5.
		문제 2의 답안 코드를 switch 문으로 변경하여 보자.
		*/
		num=-1;
		if (num < 0) {
			System.out.println("0 미만");
		}
		else {
			switch(num / 100) {
				case 0 : 
					System.out.println("0이상 100 미만");		
					break;
				case 1 : 
					System.out.println("100이상 200 미만");
					break;
				case 2 : 
					System.out.println("200이상 300 미만");
					break;
				case 3 : 
					System.out.println("300이상");
					break;
			}	
		}
		
			
	}

}
