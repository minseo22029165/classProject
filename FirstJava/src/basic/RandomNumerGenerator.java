package basic;

import java.util.Random;

public class RandomNumerGenerator {

	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextBoolean());
		System.out.println(r.nextInt());
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat());
		System.out.println(r.nextDouble());
		
		System.out.println(r.nextInt(45)+1);  // (0~44) + 1

		for(int i = 1; i < 6 ; i++) {
			System.out.print((r.nextInt(45)+1) + "\t");
		}
		System.out.println();
		
		// Random(여기에 번호값을 넣으면 랜덤값이 항상 같다. )
		Random r2 = new Random(10); 
		
		for(int i = 1; i < 6 ; i++) {
			System.out.print((r2.nextInt(45)+1) + "\t");
		}
		System.out.println();
		
		// Random(currentTimeMillis - 컴퓨터가가지고 있는 시간 - 1970.01.01 00:00 을 뺀값)
		//Random r3 = new Random(System.currentTimeMillis());
		// 컴퓨터 속도가 빨라져서 currentTimeMillis 로도 똑같은 값이 나오기 때문에 nano로 변경  
		Random r3 = new Random(System.nanoTime());
		for(int i = 1; i < 6 ; i++) {
			System.out.print((r3.nextInt(45)+1) + "\t");
		}
	}

}
