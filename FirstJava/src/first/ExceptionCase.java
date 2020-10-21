package first;

public class ExceptionCase {

	public static void main(String[] args) {
		
		
		try {
			int[] arr = new int[3]; // index 0-2
			arr[10]=20;
			
			int[] arr2 = new int[-10]; // index 0-2

			Object obj = new int[10];
			String str = (String)obj;

			String str2 = null;
			int len = str.length();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("1_" + e.getMessage());
		} catch(NegativeArraySizeException e) {
			System.out.println("2_" + e.getMessage());
		} catch(ClassCastException e) {
			System.out.println("3_" + e.getMessage());
		} catch(NullPointerException e) {
			System.out.println("4_" + e.getMessage());
		} catch(Exception e) {
			System.out.println("5_" + e.getMessage());			
		}
		
		System.out.println("메소드가 종료됩니다.");
	}

}
