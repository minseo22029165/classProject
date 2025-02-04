package marble;

public class Marble {
	/*
	문제2.
	
	다음조건을 만족하는 클래스를 구성하자. 구슬치기와 딱지치기
	어린아이가 소유하고 있는 구슬의 개수 정보를 담을 수 있다.
	놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재한다.
	두 번째 조건은 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미하는 것이다.
	조건을 만족하는 클래스를 정의하였다면, 다음조건을 만족하는 인스턴스를 각각 생성하자. ( 하나의 클래스만 작성하자 )
	어린이 1의 보유자산  구슬 15개
	어린이 2의 보유자산  구슬 9개
	
	인스턴스의 생성이 완료되면 다음의 상황을 main 메서드 내에서 시뮬레이션 하자.
	“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
	“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
	마지막으로 각각의 어린이의 보유 구슬의 개수를 출력하고 프로그램 종료. 
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// FruitSeller 타입의 참조변수 선언 
		Child child1 = new Child();		
		Child child2 = new Child();		
		
		// 1번 아이 구슬 셋팅 
		child1.marbleSet(15);
		
		// 2번 아이 구슬 셋팅 
		child2.marbleSet(9);
		
		// 1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다
		child1.gameWin(child2, 2);
		
		// 2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.
		child2.gameWin(child1, 7);
		
		// 1번 아이 보유 구슬 개수
		child1.myMarbleInfo();
		
		// 2번 아이 보유 구슬 개수
		child2.myMarbleInfo();
		
	}

}
