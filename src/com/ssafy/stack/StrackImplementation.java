package com.ssafy.stack;

public class StrackImplementation {
	
	public static void main(String[] args) {
		MyStack stk = new MyStack();
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.push(6);
		stk.pop();
		stk.print();
	}

}

class MyStack{
	public int top;
	public int stk[];
	
	public MyStack() {
		this.top = -1;
		this.stk = new int[1000];
	}
	
	public void push(int i) {
		this.stk[++this.top] = i;
	}
	
	public int pop() {
		return this.stk[this.top--];
	}
	
	public int peek() {
		return this.stk[this.top];
	}
	public void print() {
		System.out.print("[ ");
		for (int i = 0; i <= this.top; i++)
			System.out.print(this.stk[i]+" ");
		System.out.println("]");
	}
}