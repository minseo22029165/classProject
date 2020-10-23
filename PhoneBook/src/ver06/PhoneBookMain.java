package ver06;

import java.util.InputMismatchException;
import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while(true) {
			System.out.println("메뉴를 입력해주세요 ======================");
			System.out.println(Menu.INSERT + ". 저장");
			System.out.println(Menu.SEARCH + ". 검색");
			System.out.println(Menu.DELETE + ". 삭제");
			System.out.println(Menu.INFO_LIST + ". 모든 정보 출력");
			System.out.println(Menu.EXIT + ". EXIT");
			System.out.println("=====================================");
			System.out.print("\n>> ");	

			int select = 0;
			try {
				select = Util.sc.nextInt();
			// 숫자가 아닌경우 예외	
			} catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다. \n 다시 선택해주세요.");
				Util.sc.nextLine();
				continue;	
			}
			
			if(!(select >= Menu.INSERT && select <= Menu.EXIT)) {
				System.out.println("메뉴의 선택이 올바르지 않습니다. \n다시 선택해주세요.");
				continue;
			}
			
			switch(select) {
				case Menu.INSERT : 
					manager.insertInfo();
					break;
				case Menu.SEARCH : 
					manager.searchInfor();
					break;
				case Menu.DELETE : 
					manager.deleInfor();
					break;
				case Menu.INFO_LIST : 
					manager.showAllInfor();
					break;
				case Menu.EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}

		

	}

}
