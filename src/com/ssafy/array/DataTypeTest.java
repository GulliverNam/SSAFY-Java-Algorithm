package com.ssafy.array;

/*
 * ***java의 데이터 타입***
 * 
 * 기본타입(Primitive type) -> call by value
 * 	- 자바에서 기본적으로 제공하는 데이터 타입으로 
 * 	     선언된 변수에 실제 값이 저장된다.
 * 	- unsigned가 없음.
 *	- 정수:	byte	short	int		long
 *			1byte	2byte	4byte	8byte
 *
 *	- 실수:					float	double
 *							4byte	8byte
 *
 *	- 문자:			char
 *					2byte - unicode 사용(uft-16)
 *-------> boolean을 제외한 7가지 primitive간에 형변환이 가능하다.
 *
 *	- 논리:	boolean
 *			기술되어있지 않음(1byte로 예상) -> 0, 1로 형변환x
 *
 *	- 자동형변환
 *		byte => short => int => long => float(지수 11bit) => double
 *				char
 *	- 명시적형변환
 *		자동형변환 반대 방향은 직접 형변환을 해줘야함.
 *
 * 객체 - 참조형타입 (Reference type) -> call by reference / java는 call by address가 없음(pointer 존재x)
 *	- 사용자 정의 타입으로 
 *	     변수에는 hashcode가 저장되고
 *	     생성된 객체는 heap에 생성되어 hashcode를 통해 객체를 참조한다.
 *
 */

public class DataTypeTest {
	
	public static void main(String[] args) {
//		변수 선언
//		데이터타입 변수명;		or		데이터타입 변수명=값;
		int a = 10;					// primitive 타입
		
		Object o = new Object();	// reference 타입
		
		System.out.println(a);
		System.out.println(o);		// toString호출 + hashcode 값
		
	}
}
