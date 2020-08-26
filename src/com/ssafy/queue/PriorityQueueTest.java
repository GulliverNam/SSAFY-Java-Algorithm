package com.ssafy.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// PriorityQueue : String, Wrapper를 제외한 객체는 
		// Comparable이 구현되지 않는경우 error 발생
		/* 기본형 타입 데이터만 단순선언하여 저장 가능 */
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		queue.offer(1035);
		queue.offer(3);
		queue.offer(5);
		queue.offer(1);
		System.out.println(queue);
		
		// 데이터를 추출할 때 우선순위가 높은 데이터부터 추출.
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}