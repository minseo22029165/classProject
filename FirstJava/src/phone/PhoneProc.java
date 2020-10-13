package phone;
import java.util.Scanner;

public class PhoneProc {
	String nm;  // 이름
	String number;  // 전화번호
	String birth; // 생년월일
	
	PhoneInfo info[] = new PhoneInfo[100];  // 사용자 정보 넣기(최대 100개)
	
	Scanner scan = new Scanner(System.in);		
	
	// 사용자 정보 입력 
	void save(int count){
		System.out.print("이름을 입력하시오.");
		nm = scan.nextLine();
		System.out.print("전화번호를 입력하시오.");
		number = scan.nextLine();
		System.out.print("생년월일을 입력하시오.(입력 안하는 경우 엔터)");
		birth = scan.nextLine();
		
		// 배열에 정보 넣어주기 
		//if (birth.trim().length() > 0) {
		if (birth.trim().isEmpty()) {
			info[count] = new PhoneInfo(nm, number, birth);
		} else {
			info[count] = new PhoneInfo(nm, number, null);
		} 		
	}
	
	// 사용자 정보 검색 
	// 검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	void search(int count){
		System.out.print("검색할 이름을 입력하시오.");
		nm = scan.nextLine();		
		if(info[count].name.equals(nm)) {
			
		}
	}
	
	// 사용자 정보 출력 
	void print(int count){
		info[count].PersonInfo();
	}
	
}
