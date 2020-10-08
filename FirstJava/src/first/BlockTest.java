package first;

public class BlockTest {
	
	static int[] arr = new int [10];
	
	static {
		for (int i =0; i< arr.length; i++) {
			arr[i] = (int)(Math.random() * 10) + 1; // 1~10 사이의 랜덤한 값
		}
		System.out.println("배열의 요소의 초기화 작업 완료");
	}
	// 클래스초기화 블록 호출 : 코드가 로드될 때 블록의 코드가 실행  
	static {
		System.out.println("클래스 초기화 블록 {} ");
	}
	
	// 인스턴스 초기화 블록 : 인스턴스가 생성될 때 블록의 코드가 실행, 생성자보다 우선
	{
		System.out.println("인스턴스 초기화 블록 {} ");
	}
	
	BlockTest() {
		System.out.println("생성자 {} ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("BlockTest bt = new BlockTest(); ");
		BlockTest bt = new BlockTest();

		System.out.println("BlockTest bt2 = new BlockTest(); ");
		BlockTest bt2 = new BlockTest();
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}

}
