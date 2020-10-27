package thread;

public class Sum {
	int num;
	
	Sum(){
		num = 0;
	}
	
	// synchronized : 동시접근 막음 
	synchronized void addNum(int n) {
		num+=n;
	}
	
	int getNum() {
		return num;
	}

}
