package first;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 배열의 생성 : 변수들의 저장공간을 생성 
		// new 자료형[개수] : 개수 만큼의 연속된 변수를 생성하고 묶음으로 만든다. 
		int[] arr = null;
		arr = new int[3];
		
		// 배열의 참조 : 입력, 읽기
		// 배열의 이름[index] : 배열의 변수는 순차적으로 위치하기 때문에 index 값으로 참조
		// index : 0 부터 요소의 개수 -1 까지의 index를 가ㅣㄴ다.
		// 요소의 개수는 배열의 이름.length 인스턴스 변수에 저장된다. 
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		System.out.println("배열의 요소의 개수 : " + arr.length);
		
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += arr[i];			
		}
		System.out.println("배열의 총합 : " + sum);
		
		// 생성과 동시에 배열 요소의 초기화
		int[] arr2 = {1,2,3,4,5};
		System.out.println(arr2.length);
		
		int[] arr3 = null;
		arr3 = arr2;
		arr3 = arr;
		
		int[] arr4 = {1,2,3,4,5}; // 원본데이터, 주소값 : 0x100
		int[] ref;
		ref = addAllArray(arr4, 7); // addAllArray(0x100, 7) => 0x100, ref = 0x100

		if(arr4 == ref) {
			System.out.println("같은 배열참조");
		} else {
			System.out.println("다른 배열참조");
		}
		
		for(int i = 0; i <arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i] + ", ref[" + i + "] = " + ref[i]);
		}
		
		// 로또 번호 축출 프로그램
		// 정수 데이터 1~45까지 숫자를 저장하는 변수 45개를 생성 -> int타입의 배열 선언, 생성
		int[] ball = new int[45];
		
		//각 변수에 1~45까지의 숫자를 중복되지 않게 저장 
		for (int i = 0; i< ball.length; i++) { // i -> 0~44 까지 index로 사용
			ball[i] = i+1;
			//System.out.println(ball[i]);
		}
		
		// 각 index의 값들을 셔플(섞기) index=0의 값과 임의의(1~44) index의 값을 서로 바꾼다. 
		int j =0; // 임의의 index 
		int temp=0; // 각 변수의 값을 바꾸기 위한 임시변수

		for(int i=0; i<10000; i++) {
			j = (int)(Math.random() * 44)+1; // 1~ 44
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
			
		}
		
		// 6개 번호 축출
		for (int i = 0; i< 6; i++) { // i -> 0~44 까지 index로 사용
			System.out.print(ball[i] + " ");
		}	
		
		
	}
	
	// int 타입의 배열을 받고, 증가시킬 정수값을 받아서 
	// 각 배열의 요소에 받은 정수값 만큼 증가시키고 
	// 전달받은 배열을 반환 
	static int[] addAllArray(int[] ar, int addValue) {
		// int[] ar = 0x100, int addValue = 7
		for(int i = 0; i <ar.length; i++) {
			ar[i] = ar[i] + addValue;
		}
		
		return ar;			
	}
		

}
