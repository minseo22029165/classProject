package phone;

public class PhoneProc {
	String nm;  // 이름
	String number;  // 전화번호
	String birth; // 생년월일
	int count = 0;		// 총 입력 받은 사람 수 
	
	final PhoneInfo[] info;
	//Scanner scan;
	
	// 초기화 
	PhoneProc(){
		//info = new PhoneInfo[100]; // 사용자 정보 넣기(최대 100개)
		this(100);
	}	
	
	// 생성자 오버로딩 
	PhoneProc(int size){
		info = new PhoneInfo[size]; 
		//scan = new Scanner(System.in);
	}
	
	// 사용자 정보 입력 
	void save(){
		System.out.print("이름을 입력하시오.");
		nm = Util.scan.nextLine();
		System.out.print("전화번호를 입력하시오.");
		number = Util.scan.nextLine();
		System.out.print("생년월일을 입력하시오.(입력 안하는 경우 엔터)");
		birth = Util.scan.nextLine().trim();
		
		// 배열에 정보 넣어주기 
		if (birth != null && birth.trim().length() > 0) {
			info[count] = new PhoneInfo(nm, number, birth);
		} else {
			info[count] = new PhoneInfo(nm, number);
		}
		
		print(count);
		count++;
	}
	
	// 사용자 정보 검색 
	// 검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	void search(){
		if (count == 0) {
			System.out.print("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
			return; // 메소드의 종료
		}
		
		boolean search = false;
		System.out.print("검색할 이름을 입력하시오.");
		nm = Util.scan.nextLine();
		
		// 검색어 조회 
		int index = searchIndex(nm);
		
		if (index < 0) {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		}
	}
	
	// 사용자 정보 삭제 
	void delete() {
		//int index = -1;
		System.out.print("삭제할 이름을 입력하시오.");
		nm = Util.scan.nextLine();		
		
		// 검색어 조회 
		int index = searchIndex(nm);

		if (index < 0) {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		} else { 
			// 삭제 
			for(int j = index; j< count-1; j++) {
				info[j] = info[j+1];
			}
			count--;
			System.out.println("삭제되었습니다.");
		}
	} 
	
	// 인덱스 구하기 
	int searchIndex(String name) {
		int result = -1;
		for(int i = 0; i < count; i++) {
			if(info[i].name.equals(nm)) {
				result = i;
				break; // 반복문 벗어나기
			}
		}		
		return result;
	}
	
	// 전체보기 
	void viewAll() {
		if(count == 0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		
		System.out.println("------- 전체 정보를 출력합니다. (총" + count + "개) --------");
		
		for (int i =0; i< count; i++) {
			info[i].PersonInfo();
		}
	}	
	
	// 사용자 정보 출력 
	void print(int count){
		info[count].PersonInfo();
	}
	
}
