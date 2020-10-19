package ver04;

public class PhoneBookManager {
	private PhoneInfor[] phoneBook; // 정보 저장을 위한 배열 선언 
	int cnt; // 저장된 정보의 개수  : 반복의 횟수, 배열의 새로운 데이터 입력시 index로 사용가능 
	
	// 생성자로 초기화 
	PhoneBookManager(int cnt){
		phoneBook = new PhoneInfor[cnt]; // 입력한 개수만큼 배열 생성 
		cnt = 0;
	}
	
	// 배열에 친구 정보를 저장하는 기능 : 다형성을 이용한 매개변수 정의
	void addFriend(PhoneInfor p) {
		phoneBook[cnt] = p; 
		cnt++;
	}
	
	// 저장기능 
	void insertMember() {
		// 대학, 회사, 가족인지 여부 묻기 
		System.out.println("친구 관계를 입력하시오 [1 : 대학, 2 : 회사, 3 : 가족]");
		char friendNum = Util.sc.nextLine().charAt(0);
		
		// 사용자로부터 기본정보를 입력받자 : 이름, 전화번호, 주소, 이메일 
		System.out.println("친구의 정보를 입력 합니다.");
		System.out.println("이름을 입력해주세요 >>");
		String name = Util.sc.nextLine();
		
		System.out.println("전화번호를 입력해 주세요 >>");
		String pNum = Util.sc.nextLine();
		
		System.out.println("주소를 입력해 주세요 >>");
		String addr = Util.sc.nextLine();
		
		System.out.println("이메일을 입력해 주세요 >>");
		String email = Util.sc.nextLine();
		
		switch(friendNum) {
			case '1' :   // 대학 : 전공, 학년 추가 입력 
				System.out.println("전공을 입력해 주세요>>");
				String major = Util.sc.nextLine();	
				System.out.println("학년을 입력해 주세요>>");
				String year = Util.sc.nextLine();
				addFriend(new PhoneUnivInfor(name, pNum, addr, email, major, year)); 
				break;
			case '2' :   // 회사 : 회사명 
				System.out.println("회사명을 입력해 주세요>>");
				String company = Util.sc.nextLine();		
				addFriend(new PhoneCompanyInfor(name, pNum, addr, email, company)); 
				break;
			case '3' :   // 가족 : 가족관계 
				System.out.println("가족관계를 입력해 주세요>>");
				String relationship = Util.sc.nextLine();		
				addFriend(new PhoneFamilyInfor(name, pNum, addr, email, relationship));
				break;
		}
	}
	
	// 검색 기능 
	void searchMember(){
		// 저장된 데이터가 있는지 조회 
		if(cnt == 0) {
			System.out.println("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
			return; // 메소드의 종료 
		}
		
		System.out.println("정보 검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력해 주세요 : ");
		String name = Util.sc.nextLine();
		
		// 이름을 요소 index검색 
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
		} else {
			// 정보 출력 
			phoneBook[index].showData();
		}	
	}
	
	// 이름 문자열을 받아서 배열의 정보와 비교하고 index를 찾아서 반환
	int searchIndex(String name) {
		int index = -1;
		for(int i = 0; i < cnt; i++) {
			if(phoneBook[i].getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}
	
	// 삭제 기능 
	void deleteMember(){
		System.out.println("정보 삭제를 진행합니다.");
		System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		
		int index = searchIndex(name);  

		if(index < 0) {
			System.out.println("삭제하려는 이름의 정보가 존재하지 않습니다.");
		} else {
			// 정보 삭제
			for(int i = index; i < cnt - 1; i++) {
				phoneBook[i] = phoneBook[i + 1];
			}
			cnt--;
			System.out.println("삭제되었습니다.");
		}		
	}
	
	// 전체 데이터 출력 
	void displayAll() {
		if(cnt==0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		} 
			
		System.out.println("전체 정보를 출력합니다.(데이터 총 개수 : " + cnt + ")");
		for(int i = 0; i < cnt; i++) {
			phoneBook[i].showData();
			System.out.println("---------------------------");
		}
		System.out.println("---------------------------");
	}
}
