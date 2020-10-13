package arr;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 여러명의 사용자를 생성해서 처리 
		User u1 = new User(1, "king1");
		User u2 = new User(2, "king2");
		User u3 = new User(3, "king3");
		
		// 10명의 사용자를 저장할 수 있는 배열을 만들자
		// 배열은 여러개의 변수를 만드는것
		User[] users = new User[10];	// 참조변수 : 객체의 주소값을 저장
		
		// user 타입의 참조변수 10개를 만들고 묶음으로 관리 
		for(int i=0; i<users.length; i++) {
			users[i] = new User(i+1, "사용자"+(i+1));  // 참조변수 users[0] 참조값을 저장한다.
			users[i].showData();
		}
		
	}

}
