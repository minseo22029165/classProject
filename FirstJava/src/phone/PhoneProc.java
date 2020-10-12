package phone;
import java.util.Scanner;

import ver02.PhoneInfor;

public class PhoneProc {
	String nm;  // 이름
	String number;  // 전화번호
	String birth; // 생년월일
	
	PhoneInfo info[] = new PhoneInfo[10];  // 사용자 정보 넣기 (!!! 입력받은 사용자 총 수를 구하는건 모르겠어서 임의의 값 넣음 !!!)
	
	// 사용자 정보 입력 
	void save(int count){
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);		
		
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
	
	// 사용자 정보 출력 
	void print(int count){
		info[count].PersonInfo();
	}
	
}
