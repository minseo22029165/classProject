package generic;

public class FruitBox<T> {
	T fruit;  // Apple fruit
	
	// 생성자
	FruitBox(T fruit){
		this.fruit = fruit;   // public FruitBox(Apple fruit)
	}
  	
	public void store(T fruit) { // public void store(Apple fruit)
		this.fruit = fruit;
	}
	
	public T pullout() {  // public Apple pullout()
		return fruit;
	}

}
