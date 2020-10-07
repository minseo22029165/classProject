package first;

public class Pick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 배열 생성 
		String[] members = {
			"고한경", "김정현", "김효영", "남서아", "서지민",
			"양선경", "이도경", "이수진", "이정민", "장명지",
			"장윤혁", "정인수", "진효선", "최정은", "최지혜",
			"최혜인", "한우리", "한주량"
		};
		
		System.out.println("배열의 요소의 개수" + members.length);
		
		// 배열과 반복문은 절친이다.
		for(int i = 0; i < members.length; i++) {
			//System.out.println(members[i]);
		}
		
		// 임의의 요소 하나를 추출한다. 
		// index 범위의 랜덤 숫자를 추출
		int index = (int)(Math.random() * 18); // 0.0 <= index < 18.0
		System.out.println(members[index]);
		
	}

}
