package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Person implements Comparable<Person>{
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override 
	public int compareTo(Person o) {
//		if(age>o.age) {
//			return 1; //양수반환 : 전달받은 객체의 값이 작을때
//		}else if(age<o.age) {
//			return -1; //음수반환 : 전달받은 객체의 값이 클때
//		}else {
//			return 0;
//		}
		
		return age-o.age;
	}
	
	public String toString() {
		return name+"";
	}
	
	public static void main(String[] args) {
		TreeSet<Person> tSet = new TreeSet<Person>();
		
		tSet.add(new Person("son", 28));
		tSet.add(new Person("park", 40));
		tSet.add(new Person("Lee", 20));
		
		Iterator<Person> itr = tSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
