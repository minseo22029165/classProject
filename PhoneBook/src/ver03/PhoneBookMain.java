package ver03;

//import java.SCanner;

public class PhoneBookMain implements Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// PhoneBookManager 인스턴스 생성 : 배열과 메서드 사용 
		PhoneBookManager manager = new PhoneBookManager();
		//Scanner sc = new Scanner(System.in);		
		
		System.out.println("현재저장된 정보의 개수 : " + manager.cnt);
		System.out.println("저장이 가능한 정보의총 개수 : " + manager.phoneBook.length);
		
		while(true) {
			System.out.println("전화번호 관리 프로그램 ======================");
			System.out.println("메뉴를 입력하세요");
			System.out.println("1. 정보 저장");
			System.out.println("2. 정보 검색");
			System.out.println("3. 정보 삭제");
			System.out.println("4. 정보 전체보기");
			System.out.println("5. 프로그램 종료");
			System.out.println("=====================================");
			
			char insertMenu = SC.nextLine().charAt(0);
			
			switch(insertMenu) {
				case '1' :
					// 정보 저장 기능 메서드 호출
					manager.insertMember();
					break;
				case '2' :
					// 정보 검색 메서드 호출 
					manager.searchMember();
					break;
				case '3' :
					manager.deleteMember();
					break;
				case '4' :
					manager.displayAll();
					break;
				case '5' :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
			}

			//System.out.println("현재 저장된 정보의 개수 : " + manager.cnt);
			//manager.phoneBook[0].showInfor();
			
		}
	}

}
