package ver02;
import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 사용자에게 데이터를 받는다.
		Scanner s = new Scanner(System.in);
		
		while(true) {
			// 인스턴스 생성을 위해서는 이름, 전화번호, 생일 데이터 입력 
			System.out.println("저장을 위한 데이터를 입력해주세요.");
			System.out.println("이름을 입력해주세요.");
			String name = s.nextLine();
			System.out.println("전화번호를 입력해주세요.");
			String phoneNumber = s.nextLine();
			System.out.println("생일을 입력해주세요.");
			String birthday = s.nextLine();
	
			// 인스턴스 생성
			PhoneInfor infor = null;
			
			// 입력값 없이 엔터인 경우 공백 문자열을 반환
			// 문자열의 길이가 0이면 
			if (birthday.trim().length() > 0) {
				infor = new PhoneInfor(name, phoneNumber, birthday);	
			} else {
				infor = new PhoneInfor(name, phoneNumber, null);
			} 
			
			// 메서드 호출
			infor.showInfor();
		}
	}

}
