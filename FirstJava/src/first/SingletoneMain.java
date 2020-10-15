package first;

public class SingletoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Singletone s = new Singletone(); // private 라서 호출 불가능
		
		Singletone s = Singletone.getInstance(); // 이 패턴을 만들어서 싱글톤 값에 접근 

	}

}
