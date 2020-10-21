package first;

public class AgeInputException extends Exception {
	
	int age;
	
	public AgeInputException(int age) {
		super("유효하지 않은 나이가 입력되었습니다.");
		this.age = age;
	}
	
	@Override 
	public String toString() {
		System.out.println("age : " + age);
		return null;
		
	}


}
