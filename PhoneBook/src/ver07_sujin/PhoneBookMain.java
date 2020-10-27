package ver07_sujin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ver03.Util;

public class PhoneBookMain implements Util {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//PhoneBookManager manager = new PhoneBookManager(100);
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		// 파일 저장을 위한 스트림 생성
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("PhoneBook.txt"));
				
		while(true) {
			System.out.println("메뉴를 입력해주세요 ======================");
			System.out.println(Menu.INSERT + ". 저장");
			System.out.println(Menu.SEARCH + ". 검색");
			System.out.println(Menu.DELETE + ". 삭제");
			System.out.println(Menu.DISPLAY_ALL + ". 모든 정보 출력");
			System.out.println(Menu.SAVE + ". 파일저장");
			System.out.println(Menu.EXIT + ". EXIT");
			System.out.println("=====================================");
			System.out.println("\n>> ");			
			
			int select = SC.nextInt();
			
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
				case Menu.DISPLAY_ALL : 
					manager.showAllInfor();
					break;
				case Menu.SAVE : 
					manager.save();
					break;
				case Menu.EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}

		

	}

}
