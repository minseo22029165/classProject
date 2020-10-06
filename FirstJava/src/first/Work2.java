package first;

public class Work2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*﻿
		문제1.
		int 형 변수 num1, num2, num3가 각각 10,20,30 으로 초기화 되어 있다.
		다음문장을 실행하면 각각 변수에는 어떠한 값이 저장되겠는가?
		num1=num2=num3 ;
		확인 하는 코드를 작성하고, 그 결과에 대해 설명.
		
		결과 : 값은 오른쪽에서 왼쪽으로 들어감 
		*/
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		
		num1 = num2 = num3;
		
		System.out.println("num1=" + num1 + ", num2=" + num2 + ", num3=" + num3);

		/*
		문제2.
		수학식 {{(25x5)+(36-4)}-72}/5 의 계산결과를 출력하는 프로그램 작성.
		*/
		int sum = 0;
		sum = ( ( (25*5)+(36-4) )-72 )/5;
		System.out.println(sum);
		
		/*
		문제3.
		3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성.
		단. 덧셈 연산의 횟수 최소화
		*/
		int num = 3;
		int sum2 = 0; 
		for(int i = 2; i <= 4; i++) {
			sum2 = sum2 + (i * num); 
			System.out.println(num + sum2);
		}			

		/*
		문제4.
		a= {{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
		a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성
		*/
		int a = 0;
		int b = 0;
		int c = 0;
		boolean result;
		result = false;
		
		a = ( ( (25+5)+(36/4) ) -72 ) * 5;
		b = ( ( (25*5) + (36-4) ) -71 ) / 4;
		c = (128 / 4) * 2;
		
		if (a>b && b>c) {
			result = true;			
		}
		System.out.println(result);
	}

}
