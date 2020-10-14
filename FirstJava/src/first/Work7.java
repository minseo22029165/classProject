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
		System.out.println("1번문제(reverse) : " + str + " -> " + buffer.reverse());
		
		// 선생님 다른방법 
		int numOfStr = str.length();
		int index = numOfStr - 1;  // 배열이나 문자열의 위치 index는 0~(N-1)
		String result = ""; 
		buffer.delete(0, buffer.length());
		
		// String 클래스의 charAt()매서드를 이용해서 역순으로 출력
		for(int i=index; i>=0; i--) {
			result += str.charAt(i);   // result = result + String
			buffer.append(str.charAt(i));
		}
		System.out.println("1번문제(result) : " + str + " -> " + result);
		System.out.println("1번문제(buffer) : " + str + " -> " + buffer);
		
		/*
		문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
		String str = “990929-1010123”
		이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성. 
		*/
		
		str = "990929-1010123";
		System.out.println("2번문제 : " + str + " -> " + str.replace("-", ""));
		
	}

}
