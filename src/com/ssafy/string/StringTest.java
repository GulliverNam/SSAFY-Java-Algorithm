package com.ssafy.string;

public class StringTest {

	public static void main(String[] args) {
		/**
		 * String
		 * 	- new를 사용하지 않고 객체를 생성하는 유일한 class
		 * 	  - new를 통해 객체 생성시				: heap에 저장됨.
		 * 	  - new를 통해 객체를 생성하지 않는 경우		: Constant Pool에 저장됨, 똑같은 문자열인 경우 재사용
		 */
		
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		String str5 = "Hello";
		
		System.out.println(str1==str2); // 똑같은 String 재사용
		System.out.println(str1==str3); // new 사용시 새로 생성
		System.out.println(str3==str4); // new 사용시 매번 다른 객체가 생성
		
		// 문자열이 같은지 비교
		// 1. equals(~) : 대,소문자 구별해서 비교
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str5));
		// 2. equalsIgnoreCase(~) : 대,소문자 무시하고 문자만 같은지 비교
		System.out.println(str1.equalsIgnoreCase(str3));
		System.out.println(str1.equalsIgnoreCase(str5));
		
		
		String str = "hello world java ssafy";
		// split(String 구분자) : 구분자를 기준으로 문자열을 분리(tokenizing)해서 배열로 전달.
		String[] token = str.split(" ");
		
		for(String t: token)
			System.out.println(t);
	}

}
