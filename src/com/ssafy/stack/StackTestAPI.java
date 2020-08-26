package com.ssafy.stack;

import java.util.Stack;

public class StackTestAPI {

	public static void main(String[] args) {
		// API로 제공하는 자료구조(stack, linked list...)
		// - 객체만 저장할 수 있음
		// 		int -> Integer
		// 		double -> Double
		// 		byte -> Byte 
		// 		long -> Long
		// - toString()이 제공되어 데이터를 출력할 수 있음
		
		// Stack 객체에 Integer 타입들만 저장하도록 선언
		Stack<Integer> stk = new Stack<Integer>();
		
		// isEmpty()		: stack에 데이터가 없으면 true, 있으면 false return
		System.out.println(stk.isEmpty());
		
		// size()			: stack에 저장된 데이터 개수 return
		System.out.println(stk.size());
		
		// push(data)		: data를 stack의 마지막에 저장함
		stk.push(1);
		stk.push(2);
		stk.push(3);
		System.out.println(stk.toString());
		
		// clear() : 자료구조에 저장된 모든 원소를 제거하는 기능
//		stk.clear();
		
		// 스택이 비어있는 경우 peek(), pop()을 호출하면 java.util.EmptyStackException 발생
		;
		
		// peek() : 마지막 데이터를 제거하지 않고 return
		System.out.println(stk.peek());
		System.out.println(stk.peek());
		System.out.println(stk.toString());
		// pop() : 마지막 데이터를 제거하고 return
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.toString());
		// add()			: 중간삽입이 가능 (권장 x)
		// addAll()			: 특정 자료형을 한꺼번에 저장
		// contains(data)	: stack에 특정 data가 들어있으면 true, 없으면 false
		System.out.println(stk.contains(1));
		System.out.println(stk.contains("1"));
		System.out.println(stk.contains(2));
		
		// copyInto(array)	: 특정배열을 copy할 수 있음
		// firstElement()	: queue 처럼 맨 앞의 데이터를 가져올 수 있음
		// remove(index)	: 특정 index를 가져올 수 있음(권장x)
		// sort()			: 정렬 가능
		
	}

}
