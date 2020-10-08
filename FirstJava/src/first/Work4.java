package first;

public class Work4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		/*
		문제1.
		
		아래 예제는 두 개의 if문을 사용하고 있다. 한 개의 if 문만 사용하는 방식으로 변경해보자.
		int num=120;
	
		if(num>0) {
			if((num%2)==0)
			System.out.println(“양수이면서 짝수");
		}
		*/
		int num=120;

		if(num > 0 && (num % 2) == 0) {
			System.out.println("양수이면서 짝수");
		}
		
		/*
		문제2.
		
		다음과 같이 출력이 이루어지도록 작성해보자.
		num < 0 이라면 “0 미만” 출력
		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
		300 ≤ num 이라면 “300이상 “ 출력
		*/
		if (num < 0) {
			System.out.println("0 미만");
		} else if (0 <= num && num < 100) {
			System.out.println("0이상 100 미만");
		} else if (100 <= num && num < 200) {
			System.out.println("100이상 200 미만");
		} else if (200 <= num && num < 300) {
			System.out.println("200이상 300 미만");
		} else if (300 <= num) {
			System.out.println("300이상");
		} 
		
		// 강사님 
		if (num < 0) {
			System.out.println("0 미만");
		} else if (num < 100) {
			System.out.println("0이상 100 미만");
		} else if (num < 200) {
			System.out.println("100이상 200 미만");
		} else if (num < 300) {
			System.out.println("200이상 300 미만");
		} else {
			System.out.println("300이상");
		} 

		/*
​		문제3.
		
		CondOp.java를 조건연산자(3항 연산자)를 사용하지 않고,
		if~else를 사용하는 형태로 변경해 보자.
		*/
		int num1=50, num2=100;
		int big, diff;
		
		//big = (num1>num2)? num1:num2;
		if (num1 > num2) {
			big = num1;
		} else {
			big = num2;
		}
		
		System.out.println(big);
		
		//diff = (num1>num2)? num1-num2: num2-num1;
		if (num1 > num2) {
			diff = num1-num2;
		} else {
			diff = num2-num1;
		}
		System.out.println(diff);
		
		/*
		문제 4.
		
		SwitchBreak.java를 switch문이 아닌, if~else를 사용하는 형태로 변경해 보자.
		*/
		
		int n=3;
		/*
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
		*/
		
		if (n == 1) {
			System.out.println("Simple Java");
		} else if (n == 2) {
			System.out.println("Funny Java");
		} else if (n == 3) {
			System.out.println("Fantastic Java");
		} else {
			System.out.println("The best programming language");
		}
		
		System.out.println("Do you like coffee?");

		/*			
		문제 5.
		문제 2의 답안 코드를 switch 문으로 변경하여 보자.
		num < 0 이라면 “0 미만” 출력 부분은 if문을 사용하고 나머지 조건에 대해 변경하세요.
		*/
		if (num < 0) {
			System.out.println("0 미만");
		} else {
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
		
		/*			
		문제 6.
		while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성.
		*/
		int i = 1;
		int sum = 0;
		while (i < 100) {
			sum += i;
			i++;
		}
		System.out.println("1부터 99까지의 합 : " + sum);

		/*
		문제 7.
		1부터 100까지 출력한 후, 다시 거꾸로 100부터 1까지 출력하는 프로그램을 작성. while문과 do~while 문을 각각 한번씩 사용해서 작성
		*/
		int j = 1;
		while(j < 101) {
			System.out.print(j + " ");
			j++;
		}
		
		System.out.println();
		
		do {
			j--;
			System.out.print(j + " ");
		} while(j > 1);
		System.out.println();
		
		/*​
		문제 8.
		1000 이하의 자연수 중에서 2의 배수 이면서 7의 배수인 숫자를 출력하고, 그 출력된 숫자들의 합을 구하는 프로그램을 while 문을 이용해서 작성
		*/
		i = 1;
		sum = 0;
		
		System.out.println("2의 배수 이면서 7의 배수인 숫자를 출력 : ");
		while (i <= 1000) {
			if(i % 2 == 0 && i % 7 == 0 )
			{
				System.out.print(i + " ");
				sum += i; 
			}
			i++; 
		}
		System.out.println("\n2의 배수 이면서 7의 배수인 숫자 합 : " + sum);
		
		/*
		문제 9.
		for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
		*/
		sum = 1;
		for (int k = 1; k < 11 ; k++) {
			sum = sum * k; 
		}
		System.out.println("1부터 10까지를 곱해서 그 결과를 출력 : " + sum);
		/*
		문제 10.
		for 문을 이용하여 구구단 중 5단을 출력하는 프로그램 작성
		*/
		num = 5;
		for (i = 1; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}
		/*
		문제 11.
		ContinueBasic.java의 내부에 존재하는 while 문을 for 문으로 변경하여 작성
		*/
		
		num=0;
		int count=0;
		/*
		while((num++)<100){
		
			if(num%5!=0 || num%7!=0)
				continue;
		
			count++;
			System.out.println(num);
		}
		*/
		
		for(num = 1 ; num <= 100 ; num++) {
			if(num %5 != 0 || num %7 !=0 ) {
				continue;
			}
			count++;
			System.out.println(num);
		}
		System.out.println("count: " + count);
		
		/*
		문제 12.
		자연수 1부터 시작해서 모든 홀수와 3의 배수인 짝수를 더해 나간다. 그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지, 그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
		프로그램 내부에 while문을 무한 루프로 구성하여 작성.
		*/
		boolean result = true;
		num = 1;
		sum = 0;
		while(result) {
			// 홀수 or 3의 배수이면서 짝수
			if ((num % 2 == 1) || (num % 3 == 0 && num % 2 == 0) ) {
				sum += num;
				//System.out.println(sum);
				if (sum > 1000) {
					System.out.println("자연수 " + num + "일때 1000이 넘어감. 1000 넘어선 값 : " + sum);
					result = false;
				}
			}
			num++;
		}
		
		/*
		문제 13.
		구구단의 짝수 단(2,4,8)만 출력하는 프로그램 작성.
		단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
		*/
		i = 2;
		while (i<=8) {
			for (j = 1 ; j <= i; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
			i = i * 2;
		}
		
		// 강사님
		for(i = 2; i<10; i=i*2) {
			for(j = 1; j<i+1; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
		
		/*
		문제 14.
		다음 식을 만족하는 조합을 찾는 프로그램 작성. 
		A B
		B A
		------
		9 9
		*/
		for(i = 0; i <= 9; i++) {
			for(j = 0; j <=9; j++) {
				if ((10 * i + 1 * j) + (10 * j + 1 * i) == 99) {
					System.out.println("A : " + i + ", B : " + j);
				}
			}
		}
		
		/*
		문제15.
		n=1 일 때  “현재 인원은 1명 입니다.”
		n=2 일 때  “현재 인원은 2명 입니다.”
		n=3 일 때  “현재 인원은 3명 입니다.”
		n>3 일 때  “현재 많은 사람들이 있습니다.”
		위의 내용이 출력 되는 프로그램을 작성. 각각 If 문과 switch 문 사용
		*/
		n = 4;
		if(n > 3) {
			System.out.println("현재 많은 사람들이 있습니다.");
		} else if (2 < n && n < 4 ) {
			System.out.println("현재 인원은 3명 입니다.");
		}else if (1 < n && n < 3 ) {
			System.out.println("현재 인원은 2명 입니다.");
		}else if (0 < n && n < 2 ) {
			System.out.println("현재 인원은 1명 입니다.");
		}
		
		switch(n) {
			case 1 :
				System.out.println("현재 인원은 1명 입니다.");
			case 2 :
				System.out.println("현재 인원은 2명 입니다.");
			case 3 :
				System.out.println("현재 인원은 3명 입니다.");
			default : 
				if(n > 3) {
					System.out.println("현재 많은 사람들이 있습니다.");
				}
		}
		
		/*
		문제16.
		1 부터 99까지의 합을 구하는 프로그램 작성
		while문, for문, do while 문을 각각 사용
		 */
		i = 1;
		sum = 0;
		while(i < 100) {
			sum += i;
			i++;
		}
		System.out.println("1 부터 99까지의 합 : " + sum);
		
		i = 1;
		sum = 0;
		do {
			sum += i;
			i++;		
		} while(i < 100);
		System.out.println("1 부터 99까지의 합 : " + sum);
	}
}
