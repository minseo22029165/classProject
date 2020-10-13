package first;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정수 데이터 10개를 저장하는 바열 생성 
		int[] number = new int[10]; 
		
		// 임의의 숫자 0-9까지의 숫자를 배열의 각 요소에 저장
		for(int i=0; i<number.length; i++) {
			number[i] = (int)(Math.random() * 10);
			System.out.print(number[i] + " ");
		}
		
		for(int i=0; i<number.length; i++) {
			boolean changed = false;  // 자기 바뀜이 발생했는지 체크
			
			for(int j=0; j<number.length - 1 - i; j++) {
				
				// 왼쪽 인덱스의 값과 오른쪽 인덱스의 값을 비교하고 왼쪽값이 크면 자리 변경 
				if(number[j] > number[j + 1]) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
					changed = true;
				}
			}
			
			// 자리가 안바뀌었다면 끝! 
			if(!changed) {
				break;
			}
		}

		System.out.println();
		for(int k : number) {
			System.out.print(k + " ");
		}
	}

}
