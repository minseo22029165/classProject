package ver06_sujin;

import java.util.ArrayList;

import ver04.Util;

public class PhoneBookManager {
	// 전화번호 정보를 저장할 배열을 가지고 
	// 배열을 이용한 정보의 저장, 삭제, 출력을 하는 기능 
	
	// 배열 선언 : 상속 관계이기 때문에  PhoneInfor타입으로 선언 
	// ArrayList 객체 생성 
	ArrayList<PhoneInfor> pBook;
	
	// 외부에서 인스턴스 생성 못하게  private 로 바꿈 
	private PhoneBookManager(){

		// pBook 변수에 ArrayList<Phone>객체 생성 해서 대입
		pBook = new ArrayList<PhoneInfor>();
	}
	
	// 내부에서 인스턴스 생성 (static이 없으면 manager 변수 자체가 만들어 지지 않는다!!!!!!!)
	private static PhoneBookManager manager = new PhoneBookManager();
	
	// 외부에서 참조변수를 받을 수 있는 메서드 
	public static PhoneBookManager getInstance() {
		return manager;
	}
	
	// 정보 저장 
	// 1. 배열에 저장 메서드  : 다형성을 이용해서 하나의 메서드로 정의 addInfor(상위 클래스 타입의 매개변수)
	// 2. 사용자에게 받은 데이터를 인스턴스 생성 메서드 
	//    입력의 구분 : 구분에 따라 인스턴스 생성도 구분 -> addInfor() 메서드를 이용해서 정보 저장 
	
	// 배열에 전화번호 정보를 저장하는 메서드 
	void addInfor(PhoneInfor info) {
		pBook.add(info);
	}
	
	// 전화번호 정보를 인스턴스로 생성하고 배열에 저장 
	void insertInfo() {
		System.out.println("어떤 정보를 입력하시겠습니까?");
		System.out.println(Menu.UNIV + ". 대학");
		System.out.println(Menu.COM + ". 회사");
		System.out.print(Menu.CAFE + ". 동호회 \n>>");
		
		int select = 0; 
		
		try {
			select = Integer.parseInt(Util.sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("숫자로 입력해주세요. >> ");		
		}
		
		//Util.sc.nextLine();
		
		if(!(select >= Menu.UNIV && select <= Menu.CAFE)) {
			System.out.println("메뉴 선택이 올바르지 않습니다.");
			System.out.println("초기 메뉴로 이동합니다. ");
			return;
		}
		
		System.out.println("정보 입력을 시작합니다. ");
		
		
		System.out.println("이름 >> ");
		String name = Util.sc.nextLine().trim();
		System.out.println("전화번호 >> ");
		String pNum = Util.sc.nextLine().trim();
		System.out.println("주소 >> ");
		String addr = Util.sc.nextLine().trim();
		System.out.println("이메일 >> ");
		String email = Util.sc.nextLine().trim();
		
		switch(select) {
			case Menu.UNIV : 
				System.out.println("전공 >> ");
				String major = Util.sc.nextLine().trim();
				System.out.println("학년 >> ");
				int grade = 0;
				try {
					//Util.sc.nextInt();
					grade = Integer.parseInt(Util.sc.nextLine().trim());
					// 숫자가 아닌경우 예외	
				}catch(NumberFormatException e) {
					System.out.println("숫자로 입력해주세요. >> ");		
					System.out.println("학년 >> ");
					grade = Integer.parseInt(Util.sc.nextLine().trim());
				}				
				addInfor(new UnivPhoneInfor(name, pNum, addr, email, major, grade));
				break;
			case Menu.COM : 
				System.out.println("회사이름 >> ");
				String company = Util.sc.nextLine().trim();
				
				addInfor(new CompanyPhoneInfor(name, pNum, addr, email, company));
				break;
			case Menu.CAFE : 
				System.out.println("동호회 이름 >> ");
				String cafeName = Util.sc.nextLine().trim();
				System.out.println("닉네임 >> ");
				String nickName = Util.sc.nextLine().trim();
				
				addInfor(new CafePhoneInfor(name, pNum, addr, email, cafeName, nickName));
				break;
		}
		
		System.out.println("입력하신 정보가 저장되었습니다.(저장 개수 : " + pBook.size() + ")");
	}

	// 정보 검색 
	// 해당 index의 참조변수로 정보 출력
	// 배열의 index 를 찾는 메서드
	int searchIndex(String name) {
		int index = -1; // 정보가 없을때
		
		for(int i=0; i < pBook.size(); i++) {
			if(pBook.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}
	
	// 해당 index를 참조변수로 정보 출력: 사용자가 입력한 이름으로 검색 
	void searchInfor() {
		
		if(pBook.size() == 0) {
			System.out.println("입력된 정보가 없습니다.");
			return;
		}
		
		Util.sc.nextLine();		
		
		System.out.println("검색하실 이름을 입력해주세요.");
		String name = Util.sc.nextLine().trim();
		
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("검색하신 이름 " + name + "의 정보가 존재하지 않습니다. ");
			System.out.println("메뉴로 돌아갑니다.");
		} else {
			System.out.println("검색 결과 ----------------------");
			pBook.get(index).showInfo();
		}
	}
	
	// 사용자에게 이름을 입력받고 이름으로 검색 한 후 정보 삭제
	public void deleInfor() {
		Util.sc.nextLine();
		System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요.");
		String name = Util.sc.nextLine().trim(); 
		
		int index = searchIndex(name);
		if(index <0) {
			System.out.println("찾으시는 정보가 존재하지 않습니다.");
			System.out.println("메뉴로 이동합니다.");			
		} else {
			pBook.remove(index);
			System.out.println("요청하신 이름의 정보를 삭제하였습니다.");
		}
		
	}

	// 전체 데이터 출력 
	void showAllInfor() {
		// 저장된 데이터가 있는지 조회 
		if(pBook.size() == 0) {
			System.out.println("입력된 정보가 없습니다. 다시 메뉴로 이동합니다.");
			return; // 메소드의 종료 
		}
			
		System.out.println("전체 정보를 출력합니다.==========================");
		for(int i = 0; i < pBook.size(); i++) {
			pBook.get(i).showInfo();
			System.out.println("---------------------------");
		}
		
	}
}
