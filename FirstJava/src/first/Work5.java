package first;

public class Work5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		[1] 다음의 문장들을 조건식으로 표현하라.
		*/	
		// 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
		int x = 0;
		boolean result = (x > 10 && x < 20) ? true : false;
		
		// 2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
		char ch = 'c';
		result = (ch != '\u0000' && ch != '\t') ? true : false;
		
		// 3. char형 변수 ch가 ‘x' 또는 ’X'일 때 true인 조건식
		result = (ch == 'x' || ch == 'X') ? true : false;
		
		// 4. char형 변수 ch가 숫자(‘0’~‘9’)일 때 true인 조건식
		result = (ch >= '0' && ch <= '9') ? true : false;
		
		// 5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
		result = ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) ? true : false;
		
		// 6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로나눠떨어지지않을 때 true인 조건식
		int year = 0;
		result = ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) ? true : false;
		
		// 7. boolean형 변수 powerOn가 false일 때 true인 조건식
		boolean powerOn = true;
		result  = (powerOn == true) ? true : false;
		
		// 8. 문자열 참조변수 str이 “yes”일 때 true인 조건식	
		String str = null;
		result  = (str.equals("yes")) ? true : false;
		
		/*
		[2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오
		*/	
		int num = 0;
		int sum = 0;
		for(int i = 1 ; i <= 20 ; i++) {
			if(i % 2 != 0 && i % 3 != 0){
				sum += i;
			}
		} 
		System.out.println("1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합 = " + sum);
		
		/*			
		[3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.
		*/
		int add = 0;
		for (int i = 1; i <= 10 ; i++) {
			add = add + i;
			//System.out.println(add);
			sum = sum + add;
		}
		System.out.println("1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과 =" + sum);	
		
		/*			
		[4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이되는지 구하시오.			
		*/	
		result = true;
		num = 1;
		sum = 0;
		while(result) {
			if(num % 2 == 0) {
				sum -= num;
			} else {
				sum += num;
			}
			
			if (sum >= 100) {
				System.out.println("1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, " + num + "까지 더해야 총합 : " + sum);
				result = false;
			}
			num++;
			
		}
		/*			
		[5] 다음의 for문을 while문으로 변경하시오.
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=i; j++) { 
				System.out.print("*");
				System.out.println();
			}
		}
		*/		
		int i = 0;
		int j = 0;
		while(i<=10) {
			j = 0;
			while (j<=i) {
				System.out.print("*");
				System.out.println();
				j++;
			}
			i++;
		}
		/*			
		[6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을작성하시오.
		*/	
		for(i=1; i<=6; i++) {
			for(j=1; j<=6; j++) { 
				if(i + j == 6) {
					System.out.println("주사위1 : " + i + ", 주사위2 : " + j);
				}
			}
		}		
		/*			
		[7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를완성하라. (1)에 알맞은 코드를 넣으시오.
		int value = (  (1)  );
		System.out.println("value:"+value);
		*/
		int value = ( (int)(Math.random() * 6) + 1 );
		System.out.println("value:"+value);		
		/*			
		[8] 방정식 2x+4y=10의 모든 해를 구하시오. 단, x와 y는 정수이고 각각의 범위는 0<=x<=10,  0<=y<=10 이다.
		[실행결과]
		x=1, y=2
		x=3, y=1
		x=5, y=0
		*/	
		for(x=0; x<=10; x++) {
			for(int y=1; y<=6; y++) { 
				if(2 * x + 4 * y == 10) {
					System.out.println("x값 : " + x + ", y값 : " + y);
				}
			}
		}	
		/*			
		[9] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를완성하라.
		만일 문자열이"12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되어야 한다. (1)에 알맞은코드를 넣으시오.
		[Hint] String클래스의 charAt(inti)을 사용
		
		[실행결과]
		15	
		*/
			str = "12345";
			sum = 0;
			
			for(i=0; i < str.length(); i++) {
				sum += (char)str.charAt(i) - '0';	// 숫자(아스키값) - 0(아스키값) 하면 진짜 숫자나옴
			}
			System.out.println("‘1+2+3+4+5’의 결과 =" + sum);
	
		/*			
		[10] int타입의 변수 num 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하라. (1)에 알맞은 코드를넣으시오.
		[주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.
		[실행결과]
		15			
		*/
			num = 12345;
			sum = 0;

			while (num > 0) {
				sum += num % 10;
				num = num / 10;				
			}
			System.out.println("sum=" + sum);
		/*			
		[11] 피보나치(Fibonnaci) 수열(數列)은 앞을 두 수를 더해서 다음 수를 만들어 나가는수열이다. 
		예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를더해서 3이 되어서 1,1,2,3,5,8,13,21,... 과 같은 식으로 진행된다. 
		1과 1부터 시작하는피보나치수열의 10번째 수는 무엇인지 계산하는 프로그램을 완성하시오.
		
		[실행결과]			
		1,1,2,3,5,8,13,21,34,55			
		*/
			// Fibonnaci 수열의 시작의 첫 두 숫자를 1, 1로 한다.
			int num1 = 1;
			int num2 = 1;
			int num3 = 0; // 세번째 값
			
			System.out.print(num1+","+num2);
			
			for (i = 0 ; i < 8 ; i++ ) {
				num3 = num1 + num2; 
				System.out.print("," + num3);
				// 값을 옮겨줌 
				num1 = num2;
				num2 = num3;				
			}
		/*			
		12번 문제는 없습니다.
		
		[13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다. (1)에 알맞은 코드를넣어서 프로그램을 완성하시오.
		[실행결과]
		12o34는 숫자가 아닙니다.			
		*/
			String value2 = "12o34";
			ch = ' ';
			boolean isNumber = true;
			
			// 반복문과 charAt(inti)를 이용해서 문자열의 문자를
			// 하나씩 읽어서 검사한다.
			for(i=0; i < value2.length() ;i++) {
				if(value2.charAt(i) < '0' && value2.charAt(i) > '9') {
					isNumber = false;
					break;
				}
			}
			
			if (isNumber) {
				System.out.println(value2+"는 숫자입니다.");
			} else {
				System.out.println(value2+"는 숫자가 아닙니다.");
			}
	

		/*			
		[14] 다음은 숫자 맞추기 게임을 작성한 것이다. 1과 100사이의 값을 반복적으로 입력해서컴퓨터가 생각한 값을 맞추면 게임이 끝난다. 
		사용자가 값을 입력하면, 컴퓨터는 자신이 생각한값과 비교해서 결과를 알려준다. 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번만에 숫자를 맞췄는지 알려준다. (1)~(2)에 알맞은 코드를 넣어 프로그램을 완성하시오.
		
		[실행결과]
		1과 100사이의 값을 입력하세요 :50
		더 큰 수를 입력하세요.
		
		1과 100사이의 값을 입력하세요 :75
		더 큰 수를 입력하세요.
		
		1과 100사이의 값을 입력하세요 :87
		더 작은 수를 입력하세요.
		
		1과 100사이의 값을 입력하세요 :80
		더 작은 수를 입력하세요.
		
		1과 100사이의 값을 입력하세요 :77
		더 작은 수를 입력하세요.
		
		1과 100사이의 값을 입력하세요 :76
		맞췄습니다.
		
		시도횟수는 6번입니다.
		*/	
			// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
			int answer = (int)(Math.random() * 100) + 1 ;
			int input = 0; // 사용자입력을 저장할 공간
			int count = 0; // 시도횟수를 세기위한 변수
			
			// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
			java.util.Scanner s = new java.util.Scanner(System.in);
			
			System.out.println("랜덤값 = " + answer);
			
			do {
				count++;
				System.out.print("1과 100사이의 값을 입력하세요 :");
				input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.
			
				if (input == answer) {
					System.out.println("맞췄습니다.");
					break;
				} else if (input > answer) {
					System.out.println("더 작은 수를 입력하세요.");
				} else if (input < answer) {
					System.out.println("더 큰 수를 입력하세요.");
				}
			
			} while(true); // 무한반복문
			System.out.println("시도횟수는 " + count + "번입니다.");
			
		/*			
		[15] 다음은 회문수를 구하는 프로그램이다. 회문수(palindrome)란, 숫자를 거꾸로 읽어도앞으로 읽는 것과 같은 수를 말한다. 예를 들면 ‘12321’이나 ‘13531’같은 수를 말한다. (1)에알맞은 코드를 넣어서 프로그램을 완성하시오.
		[Hint] 나머지 연산자를 이용하시오.
		
		[실행결과]
		12321는 회문수 입니다.				
		*/	
			int number = 12321;
			int tmp = number;
			int result2 =0; // 변수 number를 거꾸로 변환해서 담을 변수
			while(tmp != 0) {
				result2 = result2 * 10;
				result2 = result2 + (tmp % 10);
				//System.out.println(result2);
				tmp = tmp / 10;
			}
			
			if(number == result2)
				System.out.println( result2 + "는 회문수 입니다.");
			else
				System.out.println( result2 + "는 회문수가 아닙니다.");
			
	}

}
