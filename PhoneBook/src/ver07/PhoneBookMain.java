package ver07;

import ver03.Util;

public class PhoneBookMain implements Util, Menu {

	public static void main(String[] args) {
		
		//PhoneBookManager manager = new PhoneBookManager(100);
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while(true) {
			System.out.println("메뉴를 입력해주세요 ======================");
			System.out.println(INSERT + ". 저장");
			System.out.println(SEARCH + ". 검색");
			System.out.println(DELETE + ". 삭제");
			System.out.println(DISPLAY_ALL + ". 모든 정보 출력");
			System.out.println(SAVE + ". 모든 정보 저장(file 저장)");
			System.out.println(EXIT + ". EXIT");
			System.out.println("=====================================");
			System.out.println("\n>> ");			
			
			int select = SC.nextInt();
			
			if(!(select >= INSERT && select <= EXIT)) {
				System.out.println("메뉴의 선택이 올바르지 않습니다. \n다시 선택해주세요.");
				continue;
			}
			
			switch(select) {
				case INSERT : 
					manager.insertInfo();
					break;
				case SEARCH : 
					manager.searchInfor();
					break;
				case DELETE :
					manager.deleInfor();
					break;
				case DISPLAY_ALL : 
					manager.showAllInfor();
					break;
				case SAVE : 
					manager.save();
					break;
				case EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}

		

	}

}
