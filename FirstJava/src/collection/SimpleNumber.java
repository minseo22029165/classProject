package collection;

public class SimpleNumber {
	int num;
	
	
	public SimpleNumber(int num) {
		this.num = num;
	}
	
	@Override 
	public String toString() {
		// return "SimpleNumber [num=" + num + "]";
		return String.valueOf(num); 
	}
	

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + num;
		
		return num%3;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())// 클래스 이름이 같아야 한다. 즉, 같은타입이어야 한다. 
			return false;
		SimpleNumber other = (SimpleNumber) obj;
		if (num != other.num)
			return false;
		return true;
	}


}
