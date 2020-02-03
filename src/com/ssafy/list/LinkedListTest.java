package com.ssafy.list;

import java.util.LinkedList;

/**
 * List
 * 	- 데이터를 순차적으로 유지
 * 	- 새로운 데이터를 추가할 수 있는 위치: 0 ~ size() -> size()-1까지가 아님.
 *  - 범위를 벗어나면 IndexOutOfBoundsException이 발생
 * 
 * LinkedList
 * 	- Double Link로 구성됨
 * 	- ArrayList보다 n*8byte를 더 사용한다. -> 공간사용 ↑
 *	- 중간삽입, 삭제가 많은 경우 Link 변경을 통해 처리하므로 ArrayList보다 성능이 좋다.
 *	- 
 */

public class LinkedListTest {

	public static void main(String[] args) {
		// ArrayList와 다르게 초기 size를 지정할 수 없다.
		LinkedList<String> list = new LinkedList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		System.out.println(list.toString());
		// add() : 맨 마지막에 데이터 추가
		list.add("a");
		list.add("hello");
		list.add("world");
		
		// add(int idx, 데이터) : 지정한 index에 데이터 추가
		// 	- idx 범위: 0~size
//		list2.add(5,"ssafy");
		list.add(0,"ssafy");
		
		System.out.println(list.toString());
		
		// get(int idx): 지정한 index의 데이터를 추출
		System.out.println(list.get(0));
		
		// indexOf(Object o) : 데이터 o가 저장된 index를 list 앞에서 부터 찾아서 return / 없으면 -1 return
		// lastIndexOf()	 : 데이터 o가 저장된 index를 list 뒤에서 부터 찾아서 return / 없으면 -1 return
		System.out.println(list.indexOf("a"));
		System.out.println(list.indexOf("hello"));

		// remove(int idx)  : idx번쨰의 데이터를 삭제
		// remove(Object o) : 데이터 o를 찾아서 삭제
		System.out.println(list.remove(0));
		System.out.println(list);
		System.out.println(list.remove("a"));
		System.out.println(list);
		
		// set(int idx, Object o) : idx번째의 데이터 o를 교체 - 이전데이터 삭제 후 현재데이터 추가(없으면 Error)
//		list.set(10, "ssafy");
		list.set(0, "ngw");
		System.out.println(list);
	}

}