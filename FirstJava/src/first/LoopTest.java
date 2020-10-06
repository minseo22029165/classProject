package first;

public class LoopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int i = 0;
		while(i < 5) {
			System.out.println("자바 안녕~ " + i);
			i++;
			
		}
		int j = 0;
		do {
			System.out.println("안녕 자바~ " + j);
			j++;
		} while (j < 0);
		
		
		int sum = 0;
		for (int i = 1 ; i < 11 ; i++) {
			sum += i;			
		}
		System.out.println(sum);
		
		
		int sum = 0;
		int i = 0;
		while(true) {
			if(sum>100) {
				break;				
			}
			i++;
			sum += i;			
		}
		System.out.println(i + "를 더했을때 100이 넘어갑니다. 합이 100이 넘어가는 최초의 값은 " + sum + "입니다.");
	
		
		for(int i = 0; i<11 ; i++) {
			if(i % 3 == 0) {
				continue;				
			}
			System.out.println(i);
			
		}
		
		int num = 0;
		int count = 0;
		while(num<100) {
			num++;
			if(num %5 != 0 || num%7 !=0 ) {
				continue;				
			}
			count++;
			System.out.println(num);
		}
		System.out.println("0~99 사이의 숫자중에 5의 배수이면서 7의배수인 숫자는 모두 " + count + "개가 있습니다.");
*/
		outerLoop : for (int i =1 ; i < 10 ; i++){
			innerLoop : for(int j = 1 ; j < 10; j++) {
				System.out.println("[" + i + ", " + j + "]");
				if(i % 2 ==0 && j % 2 == 0) {
					break outerLoop;
				}
				
			}
			
		}
	}

	
	
}
