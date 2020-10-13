package first;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2차원 배열의 선언 : 자료형[][] 배열의 이름 
		int[][] arr = null;
		
		// 2차원배열의 생성 : new 자료형[행의 개수][열의 개수]
		arr = new int[3][4];
		
		// 2차원 배열의 참조 : 배열이름[행의 index][열의 index], index는 0 부터시작
		arr[0][0] = 10; 
		System.out.println(arr[0][0]);
		System.out.println(arr[0].length); // arr[0]은 첫번째 1차원 배열을 가르키는 주소값을 저장하는 변수이다. 
		
//		for(int i = 0; i< arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = i + j;
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();			
//		}
		
		//showData(arr);		
		
		// 자리 배치
		String[][] place = new String[6][]; 
		place[0] = new String[2];
		place[1] = new String[4];
		place[2] = new String[3];
		place[3] = new String[3];
		place[4] = new String[3];
		place[5] = new String[3];
		showData(place);		
		
		int[][] arr3 = { 
				{1,2},
				{3,4,5},
				{6,7,8,9},				
		};
		
		System.out.println("2차월 배열의 세로길이(1차원 배열의 개수) : " + arr3.length);
		
		//for-each 구문 : 배열의 원본 데이터의 수정이 아닌 일괄참조의 목적일때 사용할 수 있다
		int[] arr4 = {1,2,3,4,5};
		int sum=0;
		for(int n : arr4) {
			n++;
			System.out.print(n + " ");
		}
		System.out.println();
		
		// 위에서 n++했어도 실제값이 변경되지 않는다.
		for(int n : arr4) {
			System.out.print(n + " ");
		}	
		System.out.println();
		
		// String index 사용
		String str = "ABCDE";
		String result = "";
		for(int i=str.length()-1 ; i>=0 ; i--) {
			result += str.charAt(i);
		}
		System.out.println(result + " ");

	}
	
	// 정수형 2차원 배열을 전달받아 모든 요소의 값을 출력하는 메서드, 반환하는 데이터는 없다.
	static void showData(int[][] arr) {
		for(int i = 0; i< arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i + j;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();			
		}		
	}

	// 정수형 2차원 배열을 전달받아 모든 요소의 값을 출력하는 메서드, 반환하는 데이터는 없다.
	static void showData(String[][] arr) {
		for(int i = 0; i< arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();			
		}		
	}
}
