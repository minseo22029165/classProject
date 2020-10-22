package basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {

		String strData = "11,22,33,44,55";
		StringTokenizer st = new StringTokenizer(strData, ",", true);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		String pNum = "Tel 82-010-999-~7777 son";
		StringTokenizer st1 = new StringTokenizer(pNum);
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}	
		System.out.println("---------------------------------");
		
		StringTokenizer st2 = new StringTokenizer(pNum, "-");
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}	
	}

}
