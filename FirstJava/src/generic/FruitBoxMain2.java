package generic;

public class FruitBoxMain2 {

	public static void main(String[] args) {
		FruitBox box1 = new FruitBox(new Apple(100));
		box1.store(new Apple(100));
		Apple apple = (Apple)box1.pullout();
		apple.showWeight();
		
		FruitBox box2 = new FruitBox(new Apple(150));
		box2.store("Apple");
		Apple apple2 = (Apple)box2.pullout();
		apple2.showWeight();
		
	}

}
