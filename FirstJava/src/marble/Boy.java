package marble;

public class Boy {
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
	
	int numOfMarble = 0;
	String name = null;
	
	void setBoy(String boyName, int num) {
		name = boyName;
		numOfMarble = num;
	}

	// 게임의 결과가 실패 -> 구슬의 개수를 감소
	void lose(int num) {
		numOfMarble -= num;
	}
	// 게임의 결과가 성공 -> 구슬의 개수를 증가
	void win(int num) {
		numOfMarble += num;
	}
	
	// 게임 후 승리 메서드 : 대상(boy), 구슬의 개수 
	void playWin(Boy friend, int num) {
		// 나의 승리 -> 나의 구슬의 개수는 증가
		win(num);
		
		// 상대방은 패배 -> 구슬을 감소 
		friend.lose(num);
	}
	
	// 구슬의 개수를 출력하는 메서드
	void showData() {
		System.out.println(name + "의 구슬의 개수는 : " + numOfMarble);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boy boy1 = new Boy();
		Boy boy2 = new Boy();
		
		boy1.setBoy("어린이1", 15);
		boy2.setBoy("어린이2", 9);
		
		// 게임 시작시 보유 구슬 정보
		System.out.println("게임 시작시 보유 구슬 정보");
		boy1.showData();
		boy2.showData();
		
		// 플레이
		boy1.playWin(boy2, 2);
		boy2.playWin(boy1, 7);
		
		// 게임 종료 후 보유 구슬 정보
		System.out.println("게임 종료 후 보유 구슬 정보");
		boy1.showData();
		boy2.showData();
		
	}
}
