package thread;

public class AdderThreadMain {

	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1, 50000);
		AdderThread at2 = new AdderThread(50001, 100000);
		
		// 쓰래드 생성 
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		// t1 쓰래드가 종료될 때까지 다른 쓰래드는 멈춘 상태로 놔둔다. (cpu를 할당받지 못하는 상태로 놔둠)
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1부터 100까지의 합은? " + (at1.getNum() + at2.getNum()));

	}

}
