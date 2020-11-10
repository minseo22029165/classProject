package ver07_sujin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import ver03.Util;

public class PhoneBookManager implements Util {
	// 전화번호 정보를 저장할 배열을 가지고 
	// 배열을 이용한 정보의 저장, 삭제, 출력을 하는 기능 
	
	// 배열 선언 : 상속 관계이기 때문에  PhoneInfor타입으로 선언 
	//private PhoneInfor[] pBook;  // 전화번호 정보를 저장할 배열 
	//private int cnt; // 배열에 저장된 요소의 개수, 배열의 index 로도 사용가능 
	
	// 배열을 이용해서 저장하는 방식을 ArrayList<T> 컬랙션을 이용해서 구현해 보자
	List<PhoneInfor> pBook;
	
	// 생성자 : 싱글톤 처리 -> 외부에서 인스턴스 생성을 금지  
	private PhoneBookManager(int num){
//		pBook = new PhoneInfor[num]; // 생성자의 매개변수으 인자를 전달받아 배열 생성 
//		cnt = 0;
		// List<PhoneInfor> 초기화
		pBook = new ArrayList<PhoneInfor>();
		
		// 생성자 호출할때 파일 불러오기
		read();
		
		
	}
	
	// 내부에서 인스턴스 생성 (static이 없으면 manager 변수 자체가 만들어 지지 않는다!!!!!!!)
	private static PhoneBookManager manager = new PhoneBookManager(100);
	
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
		//pBook[cnt] = info;
		//cnt++;
		
		pBook.add(info);
	}
	
	// 전화번호 정보를 인스턴스로 생성하고 배열에 저장 
	void insertInfo() {
		
		// 100개 입력 
		// 배열의 개수와 입력된 요소의 개수를 비교
		//if(pBook.length == cnt) {
//		if(pBook.length == cnt) {
//			System.out.println("더이상 정보를 저장할 수 없습니다. ");
//			System.out.println("일부 정보를 삭제하고 저장 공간을 확보해 주세요.");
//			return;
//		}

		int select =0;
		
		while(true) {
			System.out.println("어떤 정보를 입력하시겠습니까?");
			// System.out.println(" 1. 기본"); // 수상클래스 -> 인스턴스 생성불가
			System.out.println(Menu.UNIV+". 대학");
			System.out.println(Menu.COM+". 회사");
			System.out.println(Menu.CAFE+". 동호회");
			
			
			try {
			
				select = SC.nextInt();

				if( !(select>0 && select<4) ) {
					//System.out.println("메뉴 선택이 옳바르지 않습니다.");
					//System.out.println("초기메뉴로 이동합니다. ");
					//return;
					BadInputException e = new BadInputException(String.valueOf(select));
					throw e;
				}
			} catch (InputMismatchException | BadInputException e) {
				System.out.println("잘못된 메뉴입력입니다. 다시 선택해주세요");
				SC.nextLine();
				continue;
			}
			break;
		}
		
		SC.nextLine();
		
		System.out.println("정보 입력을 시작합니다. ");
		System.out.println("이름 >> ");
		String name = SC.nextLine();
		System.out.println("전화번호 >> ");
		String pNum = SC.nextLine();
		System.out.println("주소 >> ");
		String addr = SC.nextLine();
		System.out.println("이메일 >> ");
		String email = SC.nextLine();
		
		switch(select) {
			case Menu.UNIV : 
				System.out.println("전공 >> ");
				String major = SC.nextLine();
				System.out.println("학년 >> ");
				int grade = SC.nextInt();
				
				addInfor(new UnivPhoneInfor(name, pNum, addr, email, major, grade));
				break;
			case Menu.COM : 
				System.out.println("회사이름 >> ");
				String company = SC.nextLine();
				
				addInfor(new CompanyPhoneInfor(name, pNum, addr, email, company));
				break;
			case Menu.CAFE : 
				System.out.println("동호회 이름 >> ");
				String cafeName = SC.nextLine();
				System.out.println("닉네임 >> ");
				String nickName = SC.nextLine();
				
				addInfor(new CafePhoneInfor(name, pNum, addr, email, cafeName, nickName));
				break;
		}
		
		System.out.println("입력하신 정보가 저장되었습니다.(저장 개수 : " + pBook.size() + ")");
	}

	// 정보 검색 
	// 해당 indxe의 참조변수로 정보 출력
	// 배열의 index 를 찾는 메서드
	int searchIndex(String name) {
		int index = -1; // 정보가 없을때
		
		for(int i=0; i < pBook.size() ; i++) {
			if(pBook.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}
	
	// 해당 index를 참조변수로 정보 출력: 사용자가 입력한 이름으로 검색 
	void searchInfor() {
		System.out.println("검색하실 이름을 입력해주세요.");
		String name = SC.nextLine();
		
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
		SC.nextLine();
		System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요.");
		String name = SC.nextLine(); 
		
		int index = searchIndex(name);
		if(index <0) {
			System.out.println("찾으시는 정보가 존재하지 않습니다.");
			System.out.println("메뉴로 이동합니다.");			
		} else {
//			// 배열의 요소를 왼쪽으로 시프트 
//			for(int i = index; i< cnt-1; i++) {
//				pBook[i] = pBook[i+1];				
//			}
//			cnt--;
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
		for(int i = 0; i < pBook.size() ; i++) {
			pBook.get(i).showInfo();
			System.out.println("---------------------------");
		}
		
	}
	
	// 파일 저장 
	void save() {
		// 저장할 데이터가 있는지 확인 
		if (pBook.size() == 0) {
			System.out.println("저장할 데이터가 없습니다.");
			return;
		}
		
		try {
			// 아웃풋 스트림 오브젝트 생성(파일 생성) 
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phobook_sujin.ser"));
			
			// 파일 쓰기 
			out.writeObject(pBook);
			out.close();
			
			System.out.println("파일 저장 완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 저장에 실패하였습니다!");
		}		
	}
	
	// 파일 읽어오기
	void read() {
		// 파일 데이터 있는지 확인 
		File file = new File("phobook_sujin.ser");
		if(!file.exists()) {
			System.out.println("로드할 데이터가 없습니다.");
			return;
		}
		
		// 인풋 스트림 오프젝트 생성(파일 리드)
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("phobook_sujin.ser"));
			
			pBook = (List<PhoneInfor>)in.readObject();
			in.close();
			
			System.out.println("파일이 로딩되었습니다.");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 로딩에 실패하였습니다!");
		}
	}
}
