package com.ssafy.list;

import java.util.ArrayList;

/**
 * List
 * 	- 데이터를 순차적으로 유지
 * 	- 새로운 데이터를 추가할 수 있는 위치: 0 ~ size() -> size()-1까지가 아님.
 *  - 범위를 벗어나면 IndexOutOfBoundsException이 발생
 * 
 * ArrayList
 * 	- 배열로 List를 구현
 * 	- 중간 삽입이나 삭제가 많으면 데이터를 이동시키기 때문에 overhead가 크다.
 *
 */

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList의 생성자에 인자를 주지 않으면 객체를 버리고 시작함.
		// ArrayList에서 길이를 늘릴 때 본 데이터의 반밖에 안늘려주기 때문에 버리는 객체가 많음
		// -> 기본 size를 주는게 좋다
		// -> 필요한 size를 알고 있을 때 사용해야 좋다.
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		System.out.println(list.toString());
		ArrayList<String> list2 = new ArrayList<>(5);
		// add() : 맨 마지막에 데이터 추가
		list2.add("a");
		list2.add("hello");
		list2.add("world");
		
		// add(int idx, 데이터) : 지정한 index에 데이터 추가
		// 	- idx 범위: 0~size
//		list2.add(5,"ssafy");
		list2.add(0,"ssafy");
		
		System.out.println(list2.toString());
		
		// get(int idx): 지정한 index의 데이터를 추출
		System.out.println(list2.get(0));
		
		// indexOf(Object o) : 데이터 o가 저장된 index를 list 앞에서 부터 찾아서 return / 없으면 -1 return
		// lastIndexOf()	 : 데이터 o가 저장된 index를 list 뒤에서 부터 찾아서 return / 없으면 -1 return
		System.out.println(list2.indexOf("a"));
		System.out.println(list2.indexOf("hello"));

		// remove(int idx)  : idx번쨰의 데이터를 삭제
		// remove(Object o) : 데이터 o를 찾아서 삭제
		System.out.println(list2.remove(0));
		System.out.println(list2);
		System.out.println(list2.remove("a"));
		System.out.println(list2);
		
		// set(int idx, Object o) : idx번째의 데이터 o를 교체 - 이전데이터 삭제 후 현재데이터 추가(없으면 Error)
//		list2.set(2, "ssafy");
		list2.set(0, "ngw");
		System.out.println(list2);
	}

}