package collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		//set : 집합, 저장순서 유지하지 않는다.저장되는 값의 중복을 허용하지 않는다.
		// HashSet 인스턴스 생성 : 인스턴스를 저장하기 위한 저장공간 생성
		HashSet<String> set = new HashSet<String>();
		
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First");
  
		System.out.println(set.size());
		
		// set<E>은 저장하는 순서를 가지지 않기때문에 일괄처리를 위해서는 Iterator<E> 인스턴스를 이용해서 처리 
		// Collection<E> iterator() 메서드 -> Iterator()
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
