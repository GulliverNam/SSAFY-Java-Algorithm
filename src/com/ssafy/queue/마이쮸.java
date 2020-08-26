package com.ssafy.queue;

import java.util.LinkedList;

public class 마이쮸 {

	public static void main(String[] args) {
		int total = 20;
		int i = 1;
		LinkedList<int []> queue = new LinkedList<>();
		queue.add(new int[]{i, 1});
		int[] current = new int[2];
		while(total > 0) {
			current = queue.poll();
			total -= current[1]++;
			if(total <= 0) {
				System.out.printf("마지막 마이쭈는 %d번 사람이 %d개 가져갔습니다.\n",current[0], current[1] - 1 + total);
			}
			else {
				System.out.printf("%d번 사람이 %d개의 마이쭈를 가져감. %d개 남음\n", current[0], current[1] - 1, total);
				queue.add(current);
				queue.add(new int[] {++i,1});
			}
		}
	}

}
