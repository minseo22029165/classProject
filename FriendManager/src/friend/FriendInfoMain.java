package friend;

import java.util.Scanner;

public class FriendInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FriendInfoHandler handler = new FriendInfoHandler(10);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("* 메뉴 *");
			System.out.println("1 : 고교친구정보를 저장");
			System.out.println("2 : 대학친구정보를 저장");
			System.out.println("3 : 전체정보 출력");
			System.out.println("4 : 기본정보 출력");
			System.out.println("5 : exit");
			System.out.println("메뉴선택하세요>>");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 : case 2 :
				handler.addFriend(choice);
				break;
			case 3 :
				handler.showAllData();
				break;
			case 4 :
				handler.showAllSimpleData();
				break;
			case 5 : 
				System.out.println("시스템을 종료합니다. ");
				return; // 메인 메서드의 종료
			}
		}
	

	}

}
