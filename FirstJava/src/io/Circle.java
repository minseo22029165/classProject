package io;

import java.io.Serializable;

//implements Serializable : 직렬화의 대상이다, 인스턴스 저장이 가능하다. 
// 직렬화를 하기 위해서는 반드시 implements Serializable를 구현 해주어야 한다.  
public class Circle implements Serializable{
	
	int xPos, yPos;
	double rad;
	
	public Circle(int xPos, int yPos, double rad) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.rad = rad;
	}
	
	public void showCircleInfo() {
		System.out.printf("[%d, %d] \n", xPos, yPos);
		System.out.println("rad : " + rad);
	}

}
