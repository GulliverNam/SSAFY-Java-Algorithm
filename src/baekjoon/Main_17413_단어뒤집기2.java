package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_17413_단어뒤집기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> deque = new LinkedList<Character>();
		boolean open = false;
		for (Character c : br.readLine().toCharArray()) {
			if(!open) {
				if(c == '<') {
					open = true;
					while(!deque.isEmpty()) {
						System.out.print(deque.pop());
					}
					deque.offer(c);
				} else if (c == ' ') {
					while(!deque.isEmpty()) {
						System.out.print(deque.pop());
					}
					System.out.print(" ");
				}
				else
					deque.push(c);
			} else {
				deque.offer(c);
				if(c == '>') {
					open = false;
					while(!deque.isEmpty()) {
						System.out.print(deque.poll());
					}
				}
			}
			
		}
		if(!deque.isEmpty()) {
			while(!deque.isEmpty()) {
				System.out.print(deque.pop());
			}
		}
		
	}

}
