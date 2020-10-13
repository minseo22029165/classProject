package first;

public class Work7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		문제 1. 다음 형태로 String 인스턴스를 생성.
		String str = “ABCDEFGHIJKLMN”;
		그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.
		*/
		
		String str = "ABCDEFGHIJKLMN";
		
		// reverse()를 사용하기 위해 StringBuffer 생성
		StringBuffer buffer = new StringBuffer();
		
		// StringBuffer에 입력값 넣어주기 
		buffer.append(str);
		System.out.println("1번문제 : " + str + " -> " + buffer.reverse());
		
		/*
		문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
		String str = “990929-1010123”
		이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성. 
		*/
		
		str = "990929-1010123";
		System.out.println("2번문제 : " + str + " -> " + str.replace("-", ""));
		
	}

}
