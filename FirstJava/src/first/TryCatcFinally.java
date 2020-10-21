package first;

public class TryCatcFinally {

	public static void main(String[] args) {

		try {
			int num =10/0;
		}
		catch(Exception e){
			System.out.println("예외발생");
		}finally {
			System.out.println("try구문에 진입하면 무조건 실행하는 finally블록");
		}
		

	}

}
