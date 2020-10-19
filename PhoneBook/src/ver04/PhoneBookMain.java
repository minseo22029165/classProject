package ver04;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager(10);  // 등록할 연락처 최대 10개

		// 메뉴 구현 
		while(true) {
			System.out.println("전화번호 관리 프로그램 ======================");
			System.out.println("1. 정보 입력");
			System.out.println("2. 정보 검색");
			System.out.println("3. 정보 삭제");
			System.out.println("4. 정보 전체보기");
			System.out.println("5. 프로그램 종료");
			System.out.println("=====================================");
			System.out.println("메뉴를 입력하세요 >> ");
			char choice = Util.sc.nextLine().charAt(0);
			
			switch(choice) {
				case '1' :
					// 정보 저장 기능 메서드 호출
					manager.insertMember();
					break;
				case '2' :
					// 정보 검색 메서드 호출 
					manager.searchMember();
					break;
				case '3' :
					// 정보 삭제 메서드 호출
					manager.deleteMember();
					break;
				case '4' :
					// 전체보기 메서드 호출 
					manager.displayAll();
					break;
				case '5' :
					// 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					return;
			}
			
		}

	}

}
