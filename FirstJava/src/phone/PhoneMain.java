package phone;

import java.util.Scanner;

/*
	Project : ver 0.20
	“프로그램 사용자로부터 데이터 입력”
	프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
	핵심.
	단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
	프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
	키보드로부터 데이터 입력 
	입력 받은 데이터로 인스턴스 생성 
	생성된 인스턴스의 메소드 호출	 
 */
public class PhoneMain {

	public static void main(String[] args) {
		String startYn = "N";  // 입력 여부 Y : 입력, N : 종료 
		int count = 0;		// 총 입력 받은 사람 수 
		
		Scanner scan = new Scanner(System.in);		
		
		// 전화번호부 처리 클래스
		PhoneProc proc = new PhoneProc();
		
		// 전화번호부 입력 받기 
		while(true) {
			System.out.println("전화번호부 입력 [시작 : Y], [종료 : N]");
			startYn = scan.nextLine();
			
			if (startYn.equals("Y") || startYn.equals("y")) {				
				// 전화번호부 등록 함수 호출
				proc.save(count);
				count++;
			} else {
				System.out.println("전화번호부 종료");
				break;				
			}
		}
		
		//System.out.println(count);
		
		// 입력된 전화번호부 출력 
		for (int i = 0 ; i < count; i++) {
			proc.print(i);			
		}
	}

}
