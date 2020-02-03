package com.ssafy.queue;

import java.util.LinkedList;

public class QueueTest_API {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		
		System.out.println(queue.size());
		System.out.println(queue.peek());
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		// contains(o) : 인자에 해당하는 객체가 저장되어 있으면 true, 없으면 false
		System.out.println(queue.contains(3));
		System.out.println(queue.contains(5));
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		
		// poll	: 맨 앞의 데이터를 삭제하면서 추출(deQueue)
		System.out.println(queue.poll());
		System.out.println(queue);

	}

}
