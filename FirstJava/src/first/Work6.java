package first;

import java.util.Scanner;

public class Work6 {
	// TODO Auto-generated method stub

	public static void main(String[] args) {
		
		Work6 work6 = new Work6();
		Scanner scan = new Scanner(System.in);
		
		/*
		 문제1.
		두 개의 정수를 전달받아서, 두수의 사칙연산 결과를 출력하는 메서드와 이 메서드를 호출하는 main메서드를 정의해보자.
		단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.
		 
		*/
		System.out.println("--------[문제1]--------");
		System.out.print("첫번째 정수를 입력하시오");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수를 입력하시오");
		int num2 = scan.nextInt();		
		
		work6.calculus(num1, num2);
		
		/*
		문제2.
		두 개의 정수를 전달 받아서, 두수의 절대값을 계산하여 출력하는 메서드와 이 메서드를 호출하는 main메서드를 정의해 보자. 단 메서드 호출 시 전달되는 값의 순서에 상관없이 절대값이 계산되어서 출력되어야 한다.
		*/		
		System.out.println("--------[문제2]--------");
		System.out.print("첫번째 정수를 입력하시오");
		int num3 = scan.nextInt();
		System.out.print("두번째 정수를 입력하시오");
		int num4 = scan.nextInt();
		
		work6.absolute(num3, num4);
	
		/*
		문제3.
		원의 반지름 정보를 전달하면, 원의 넓이를 계산해서 반환하는 메서드와 원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고, 이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)
		*/		
		System.out.println("--------[문제3]--------");
		System.out.print("원의 반지름을 입력하시오");
		float num5 = scan.nextFloat();
		System.out.println("원의 둘레 : " + work6.circumference(num5));
		System.out.println("원의 넓이 : " + work6.circleArea(num5));
		
		/*
		문제4.
		전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.
		*/		
		System.out.println("--------[문제4]--------");
		
		System.out.println("1이상 100 이하의 소수를 전부 출력 : ");	
		for (int i = 1 ; i <= 100; i++) {
			// 소수인지 아닌지 판별
			if (work6.prime(i)) {
				System.out.print(i + " ");	
			}			
		}
		
	}

	/*
	 문제1
	*/
	void calculus(int num1, int num2) {
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2) + ", 나머지 : " + (num1 % num2));
	}

	/*
	문제2
	*/
	void absolute(int num1, int num2) {
		num1 = (num1 < 0)? -num1 : num1;
		num2 = (num2 < 0)? -num2 : num2;
		System.out.println("절대값 계산 : " + num1 + " + " + num2 + " = " + (num1 + num2));		
	}

	/*
	문제3
	*/
	final float PI = 3.14f; 
	
	// 리턴 : 원의 넓이
	float circleArea(float r) {
		return PI*r*r;
	}
	
	// 리턴 : 원의 둘레
	float circumference(float r) {
		return 2*PI*r;
	}
	
	/*
	문제4
	 */
	
	// 리턴 : 전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드
	boolean prime(int num) {
		boolean result = true;
		
		if (num > 1) {
			for(int i = 2; i < num; i++) {
				if(num % i == 0) {
					result = false;
					break;
				}
			}
		} else {
			result = false;
		}
		
		return result;
	} 
	
		
}
