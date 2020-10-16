package first;

import java.util.Scanner;

public class ExamArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 배열선언
		int[] arr = new int[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개를 입력해주세요.");
		
		for(int i =0 ; i < arr.length; i++) {
			System.out.println("정수를 입력해주세요. >>");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("최대값은 : " + maxValue(arr));
		System.out.println("최소값은 : " + minValue(arr));

		
		int[][] arr2 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}	
		};
		
		addOneDArr(arr2, 5);
		for(int i =0 ; i < arr2.length; i++) {
			for(int j =0 ; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}	
			System.out.println();
		}
		
		System.out.println();
		changeArr(arr2);	
		for(int i =0 ; i < arr2.length; i++) {
			for(int j =0 ; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}	
			System.out.println();
		}
				
	}

	/*
	 문제 1.
	int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
	
	public static int miniValue(int[] arr) { . . . . } // 최소값 반환
	public static int maxValue(int[] arr) { . . . . } // 최대값 반환
	위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
	두 매소드 실행을 확인인하기 위한 main 메소드 정의.
	int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
	임의로 결정
	 */
	public static int minValue(int[] arr) {  // 4,3,7,5
		int min = arr[0];
		for(int i = 0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	// 전달받은 1차원 배열에서 최대값을 축출해서 반환하는 메서드
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i = 0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;		
	}
	
	/*
	문제 2.
	다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 값의 크기만큼 전부 증가시킨다.
	public static void addOneDArr(int[] arr, int add){
	         for (int i=0, i<arr.length; i++)
	         arr[i] +=add;
	}﻿
	이 메서드를 기반으로(이 메서들르 호출하는 형태로)int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
	public static void addOneDArr(int[][] arr, int add) { . . . . . }
	단 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.
	 */
	public static void addOneDArr(int[][] arr, int add){
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] += add;
			}
			
		}
		
	}
	
	/*	
	문제 3.
	다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
	1 2 3
	4 5 6
	7 8 9
	이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
	7 8 9
	1 2 3
	4 5 6
	즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다. 이번에도 마찬가지로 배열의 가로, 세로길이에 상관 없이 동작을 하도록 메서드가 정의되어야 하며, 정의된 메서드의 확인을 위한 main메서드도 함께 정의하자.
​	*/
	public static void changeArr(int[][] arr) {
		// 2차언 배열은 1차원 배열들을 요소로  갖는 배열이다. 
		// 1차원 배열들의 위치를 변경 -> 2차원 배열이 가지는 1차원 배열의 주소값이 변경되는 것과 같다 
		// 주소값의 변경을 위한 임시 배열을 선언하고 생성해야 한다.
		//int[] temp = new int[arr[0].length];
		int[] temp = new int[arr[arr.length-1].length];
		
		temp = arr[arr.length-1]; // 마지막 배열값 주소 넣기
		
		for(int i = arr.length-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		
		arr[0] = temp;
	}
}
