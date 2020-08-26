package com.ssafy.queue;

class MyQueue{
	
	private Object[] queue;
	/* 데이터를 입력하는 위치를 위한 index */
	private int rear;
	/* 데이터를 추출하는 위치를 위한 index */
	private int front;
	/* queue의 총 size*/
	private int n;
	/* queue에 저장된 데이터 수*/
	private int size;
	public MyQueue(){
		this.n = 5;
		this.queue = new Object[n];
		this.rear = 0;
		this.front = 0;
	}
	public MyQueue(int n){
		this.n = n;
		this.queue = new Object[n];
		this.rear = 0;
		this.front = 0;
	}
	
	public boolean isFull() {
		if(this.rear == this.n) return true;
		return false;
	}
	
	public boolean isEmpty() {
		if(this.rear == this.front) return true;
		return false;
	}
	
	public void enQueue(Object data) {
		if(this.isFull()) {
			throw new RuntimeException("Queue is full");
		}
		this.queue[rear++] = data;
		this.size++;
	}
	
	public Object peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return this.queue[this.front];
	}
	
	public Object deQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		this.size--;
		return this.queue[this.front++];
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(size*2+2);
		sb.append("[");
		if(size>0) {
			for (int i = front; i < rear; i++) {
				sb.append(queue[i]);
				if(i != rear-1) sb.append(" ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}

public class QueueTest {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enQueue(5);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println(queue);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue);
	}

}
