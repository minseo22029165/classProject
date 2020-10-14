package phone;

/*
 	Version 0.1
	회원번호 관리 프로그램.
	PhoneInfor 라는 이름의 클래스를 정의해 보자.
	 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며,
	 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	• 이름 name String
	• 전화번호 phoneNumber String
	• 생년월일 birthday String
	 단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성

	Project : ver 0.20
	“프로그램 사용자로부터 데이터 입력”
	프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
	핵심.
	단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
	프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
	키보드로부터 데이터 입력 
	입력 받은 데이터로 인스턴스 생성 
	생성된 인스턴스의 메소드 호출	 
	
	 Project : ver 0.30
	배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지
	유지되도록 프로그램을 변경. 아래기능 삽입
	저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
	데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
	재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.	
 */
public class PhoneMain {

	public static void main(String[] args) {
		// 전화번호부 처리 클래스
		PhoneProc proc = new PhoneProc();
		
		// 전화번호부 입력 받기 
		while(true) {
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("메뉴를 입력하세요  [1 : 입력, 2 : 검색, 3 : 삭제, 4 : 전체출력, 5 : 종료]");
			System.out.println("-------------------------------------------------------------");
			char menuNum = Util.scan.nextLine().charAt(0);
			
			switch(menuNum) { 
				case '1' : // 입력 
					// 전화번호부 등록 함수 호출
					proc.save();
					break;
				case '2' : // 검색
					proc.search();
					break;					
				case '3' : // 삭제
					proc.delete();
					break;
				case '4' : // 전체보기
					proc.viewAll();
					break;					
				case '5' : // 종료
					System.out.println("전화번호부 종료");
					System.exit(0);
					break;
				default : // 이상한값 
					System.out.println("값을 잘못 입력하였습니다. 제대로 입력하시오.");
					break;
			}
		}
			

	}

}
