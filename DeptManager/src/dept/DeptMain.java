package dept;

import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {
		
		DeptManager manager = new DeptManager();
		
		Scanner sc = new Scanner(System.in);
		
		
		// database driver load
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			while(true) {

				System.out.println("메뉴 입력 >>");
				System.out.println("1. 입력, 2. 수정, 3. 삭제, 4. 전체리스트, 5. 검색, 6. 종료");
				System.out.println("-------------------------------------------------");
				String select = sc.nextLine();
				
				switch(select.charAt(0)) {
					case '1' :
						manager.insertDept();
						break;
					case '2' :
						manager.editDept();
						break;
					case '3' :
						manager.delDept();
						break;
					case '4' :
						manager.listDept();
						break;
					case '5' :
						manager.searchDept();
						break;
					case '6' :
						System.out.println("프로그램을 종료합니다.");
						return;			
				}				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
