package triangle;

public class Triangle {

	float width = 0;
	float height = 0; 
	
	// 밑변과 높이 정보를 변경시킬 수 있는 메서드
	void updateSize(int x, int y) {
		width = x;
		height = y;
	}
	
	// 삼각형의 넓이를 계산해서 반환하는 메서드
	float triangeArea() {
		float area = width * height / 2; // 삼각형 넓이 계산 : 가로 * 세로 / 2
		return area;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체 생성
		Triangle triangle = new Triangle();
		
		// 삼각형 가로, 세로 길이 수정 
		triangle.updateSize(10, 20);
		
		// 삼각형 넓이 계산 
		float triangleSize = 0;
		triangleSize = triangle.triangeArea();
		System.out.println("삼각형 가로 : " + triangle.width + ", 삼각형 세로 : " + triangle.height + ", 삼각형 넓이 : " + triangleSize);
	}

}
