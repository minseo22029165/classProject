package first;

import java.text.SimpleDateFormat;

public class PackageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Date today = new java.util.Date();
		
		//System.out.println(today);
		
		/*
			yyyy : 년
			MM : 월
			dd : 일 
			hh : 시  
			mm : 분 
			ss : 초
			a -> 오전 / 오후
		*/
		// 2020.10.15 10:56
		SimpleDateFormat date = null;
		date = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		
		String now = date.format(today);
		System.out.println(now);

	}

}
