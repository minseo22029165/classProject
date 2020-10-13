package first;

public class ArrayCopyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 사용할 원본 배열 생성 
		char[] abc = {'A', 'B', 'C', 'D'};
		char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		System.out.println("abc : " + new String(abc));
		System.out.println("number : " + new String(number)); // new String --> 들어가있는 문자열을 연결해서 객체로 생성
		
		// abc배열과 number배열을 연결해서 사용할 배열 생성 
		char[] result = new char[abc.length + number.length];
		System.out.println(result.length);
		
		// 배열 카피 
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.out.println("result : " + new String(result));
		
		// number를 0번째부터 result에 넣는데 abc.length번째부터 number.length개를 카피 
		System.arraycopy(number, 0, result, abc.length, number.length);
		System.out.println("result : " + new String(result));
		
		// abc를 number에 0부터 복사
		System.arraycopy(abc, 0, number, 0, abc.length);
		System.out.println("number : " + new String(number));

		// number index=6부터 abc index=0 3개를 복사
		System.arraycopy(abc, 0, number, 6, 3);
		System.out.println("number : " + new String(number));
	}

}
