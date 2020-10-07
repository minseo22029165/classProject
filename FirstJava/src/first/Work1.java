package first;

public class Work1 {
	/*
	[1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오.


	[2] 주민등록번호를 숫자로 저장하고자 한다. 이 값을 저장하기 위해서는 어떤 자료형

	(data type)을 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로

	초기화 하는 한 줄의 코드를 적으시오.
	
	long regNo;
	regNo = 0000000000000L;

	//강사님꺼 2000년대 생인경우 위와같이 하면 안된다
	String regNo1 = "000000-0000000";

	
	[3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.

	int i = 100;
	long l =100L;
	final float PI =3.14f;

	- 리터럴 : 100, 100L, 3.14f
	- 변수 : i, l
	- 키워드 : int, long, final, float
	- 상수 : PI


	[4] 다음 중 기본형(primitive type)이 아닌 것은? 

	a. int
	b. Byte  // 대문자 구별
	c. double
	d. boolean

	​

	[5] 다음 문장들의 출력결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 ‘오류’라고적으시오.
	
	System.out.println(“1” + “2”) → (12 )
	System.out.println(true+ “”) → ( true)
	System.out.println(‘A'+ 'B') → ( 131)
	System.out.println('1'+ 2) → ( 51)
	System.out.println('1'+ '2') → ( 99)
	System.out.println('J'+ “ava”) → ( Java)
	System.out.println(true+ null) → ( 오류)
	​

	[6] 다음 중 키워드가 아닌 것은?(모두 고르시오)

	a. if
	b. True   // true
	c. NULL  // null
	d. Class  // class
	e. System  // system
	​

	[7] 다음 중 변수의 이름으로 사용할 수 있는 것은? (모두 고르시오)

	a. $ystem  // 특수문자는 $와 ﻿_ 만가능
	b. channel#5  // #불가능
	c. 7eleven   // 숫자가 앞에 놓이면 안됨
	d. If  // if 가 키워드라 가능
	e. 자바 // 한글 가능하지만 안쓰는게 좋음
	f. new // 키워드라 불가능
	g. $MAX_NUM // 특수문자는 $와 ﻿_만 가능
	h. hello@com // 특수문자 @ 불가능
	​

	[8] 참조형 변수(reference type)와 같은 크기의 기본형(primitivetype)은? (모두 고

	르시오)

	a. int  // 참조형 변수는 4byte
	b. long
	c. short
	d. float  // 참조형 변수는 4byte
	e. double
	​

	[9] 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)

	byte b = 10;
	char ch = 'A';
	int i = 100;
	long l = 1000L;
	​
	a. b = (byte)i;
	b. ch = (char)b;
	c. short s =(short)ch;
	d. float f =(float)l;
	e. i = (int)ch;

	--> 아래와 같은 방향으로 형변환 가능
	byte -> short -> int -> long -> float -> double
            char  ->


	[10] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)

	0~ 65535 (2^16 음수X => 65536 - 1(0포함해야 하기 때문에 -1) )
​

	[11] 다음중 변수를 잘못 초기화 한 것은? (모두 고르시오)

	a. byte b = 256; // -128 ~ 127
	b. char c = '';    // 공백 못들어감
	c. char answer ='no';  // 한자리수
	d. float f = 3.14 // f 들어가야함
	e. double d = 1.4e3f;
	​

	[12] 다음 중 main메서드의 선언부로 알맞은 것은? (모두 고르시오)

	a. public static void main(String[] args)
	b. public static void main(String args[])
	c. public static void main(String[] arv)  // 변수의 이름은 아무거나 해도 상관없다
	d. public void static main(String[] args)   // static와 void는 위치가 바뀌면 안된다
	e. static public void main(String[] args) // static 와 public 는 위치가 바뀌어도 상관없다
	​

	[13] 다음 중 타입과 기본값이 잘못 연결된 것은? (모두 고르시오)

	a. boolean - false
	b. char - '\u0000'
	c. float - 0.0  // 0.0f
	d. int - 0
	e. long - 0  // 0L
	f. String -""  // null
	*/
}
