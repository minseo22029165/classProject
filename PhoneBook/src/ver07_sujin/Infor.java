package ver07_sujin;

import java.io.Serializable;

// 파일 직렬 처리를 위해 Serializable extends 함 
public interface Infor extends Serializable {
	// public abstract 가 생략 가능 
	void showInfo();  
	void showBasicInfor();
}

