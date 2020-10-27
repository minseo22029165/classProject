package thread;

public class Calcurator {
	int opPlusCnt = 0;
	int opMinCnt = 0;
	
	// synchronized : 동시접근 막음 
	//synchronized public int add(int n1, int n2) {
	public int add(int n1, int n2) {
		// 동기화 블럭 : 이렇게 해주면 return 값은 먼저 반환하지만 이부분은 누가 사용 중이면 대기
		synchronized (this) {
			opPlusCnt++;
		}
		
		return n1+n2;
	}

	// synchronized : 동시접근 막음 
	//synchronized public int min(int n1, int n2) {
	public int min(int n1, int n2) {
		// 동기화 블럭 : 이렇게 해주면 return 값은 먼저 반환하지만 이부분은 누가 사용 중이면 대기
		synchronized (obj) {
			opMinCnt++;
		}
		
		return n1-n2;
	}
	
	// 새로운 동기화 키 
	Object obj = new Object();
}
