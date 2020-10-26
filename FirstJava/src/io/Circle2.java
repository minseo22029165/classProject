package io;

import java.io.Serializable;

//implements Serializable : 직렬화의 대상이다, 인스턴스 저장이 가능하다. 
// 직렬화를 하기 위해서는 반드시 implements Serializable를 구현 해주어야 한다.  
public class Circle2 implements Serializable{
	
	Point p;
	double rad;
	
	public Circle2(int xPos, int yPos, double rad) {
		p = new Point(xPos, yPos);
		this.rad = rad;
	}
	
	public void showCircleInfo() {
		System.out.printf("[%d, %d] \n", p.x, p.y);
		System.out.println("rad : " + rad);
	}

}
