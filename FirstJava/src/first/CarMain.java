package first;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1  = new Car(100);
		HybridCar car2 = new HybridCar(100,50);
		HybridWaterCar car3 = new HybridWaterCar(100,50,40);
		
		car3.showCurrentGauge();
		
		// 클래스멤버도 상속의 대상이다. 클래스멤버는 한번만 생성
		System.out.println(Car.name);
		System.out.println(HybridCar.name);
		System.out.println(HybridWaterCar.name);
	}

}

class Car {
	static String name ="car";
	int gasolinegauge;
	
	Car(int gasolinegauge){
		this.gasolinegauge = gasolinegauge;
	}
}

class HybridCar extends Car {
	int electronicGauge;
	
	HybridCar(int gasolinegauge, int electronicGauge){
		// 조상 클래스의 멤버를 초기화 하는 생성자 호출
		super(gasolinegauge);
		// 새롭게 정의한 클래스의 멤버를 초기화 
		this.electronicGauge = electronicGauge;
	}
}

class HybridWaterCar extends HybridCar {
	int waterGauge;
	
	HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
		super(gasolinegauge, electronicGauge);
		this.waterGauge = waterGauge;
	}

	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolinegauge);
		System.out.println("잔여 전기 : " + electronicGauge);
		System.out.println("잔여 water : " + waterGauge);
	}
}