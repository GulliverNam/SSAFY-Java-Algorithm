package com.ssafy.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest1 {
	
	public static void main(String[] args) {
		/*
		 * ***배열***
		 * - 변수 하나에 여러 개의 공간을 할당해서 같은 타입의 값만 저장
		 * 
		 * - 어떤타입이든 배열을 선언할 수 있고 배열은 Reference 타입이다.
		 * 
		 * - Java의 배열 index는 0부터 시작
		 *   접근 범위를 벗어나면 ArrayIndexOutOfBoundsException이 발생한다.
		 *   
		 * - 배열의 size는 0부터 양의 정수만 지정할 수 있다.
		 *   음수로 지정하면 NegativeArraySizeException이 발생한다.
		 *   
		 * - 배열의 크기는 생성시에만 설정할 수 있고 이후에는 크기 변경이 불가능하다.
		 *   => 배열의 크기를 변경하려면 새로운 배열을 생성해서 기본 배열의 값을 복사해야 한다.
		 *   => c++ 코드를 끌어와서 memory copy를 해주는 구문
		 *   	Arrays.copyOf(~)
		 *   	System.arrayCopy(~)
		 *   
		 * - 배열이 생성되면 기본값으로 초기화 된다.
		 *   정수: 0
		 *   실수: 0.0
		 *   문자: \u0000
		 *   논리: false
		 *   참조형: null
		 * 
		 * - 속성
		 *   length: 배열의 size
		 *  
		 * 
		 * - 선언
		 * 	 DataType[] 변수명; 		int의 배열 type
		 * 	 DataType 변수명[];		
		 * 	 DataType[] i,j,k;		i,j,k는 모두 int의 배열 type
		 * 	 DataType i,j,k[];		k만 int의 배열 type, i,j는 int 타입
		 * 	 DataType 변수명[size];(x)	컴파일 에러
		 * 
		 * - 생성
		 * 	 변수명 = new DataType[size];
		 *
		 * - 선언&생성
		 *   DataType[] 변수명 = new DataType[size];
		 *   
		 * - 할당
		 *   변수명[index] = 값;
		 *   
		 * - 선언&생성&할당	=>	할당된 값의 개수가 배열의 size가 된다.
		 *   DataType[] 변수명 = {값1, 값2, ...};
		 *
		 */
		
		int[] i,j,k;			//모두 일차원 int배열
		int a,b,c[];			//c만 일차원 int배열
		int[] l, m[], n[][];	// l은 1차원, m은 2차원, n은 3차원 배열
		
		int[] array1 = new int[3];
		array1[0] = 10;
		
//		stack에서 hashcode를 찾아 queue로 접근하는 것 보다 local variable을 이용해 접근하는 것이 속도가 빠름.
//		heap에 갈 일을 최대한 줄여야 좋은 코드이다.
		for (int o = 0, length = array1.length; o < length; o++)
			System.out.printf("array1[%d] = %d\n", o, array1[o]);
		
		int[] array2 = {0,1,2,3,4,5,};
		
//		Arrays
//		- method
//			copyOf
//			copyOfRange
//			fill
		System.out.println(Arrays.toString(array2));
		String str = "12345";
		
	}
	
}
