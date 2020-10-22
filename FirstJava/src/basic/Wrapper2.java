package basic;

public class Wrapper2 {

	public static void main(String[] args) {

		//Integer iValue = new Integer(10) or Integer iValue = Integer.valueOf(10); 과 같다. 
		Integer iValue = 10; // AUTO BOXING 	
		System.out.println(iValue);
		
		// Double dValue = new Dluble(3.14); or Double dValue = Double.valueOf(3.14);
		Double dValue = 3.14;
		System.out.println(dValue);
		
		// Integer -> int 로 AUTO UNBOXING 
		int num1 = iValue; 
		double num2 = dValue; 
		
		System.out.println(num1);
		System.out.println(num2);

	}

}
