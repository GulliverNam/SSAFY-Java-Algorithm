package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
5
2 0 1 4 3
 */

public class Main_1115_순열 {
	
	static int N, target[], answer;
	static Queue<Permutation> queue = new LinkedList<Permutation>();
	
	static class Permutation{
		int prev, arr[];

		public Permutation(int prev, int[] arr) {
			this.prev = prev;
			this.arr = arr;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		target = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		queue.add(new Permutation(0, target));
		for (int i = 0; i < N-1; i++) {
			for (int j = 0, size = queue.size(); j < size; j++) {
				addQueue(queue.poll());
			}
			System.out.println("-------------------");
		}
	}
	private static void addQueue(Permutation p) {
		for (int i = 0; i < N; i++) {
			if(i != 0 && i != p.prev){
				int tempArr[] = p.arr.clone();
				int temp = tempArr[0];
				tempArr[0] = tempArr[i];
				tempArr[i] = temp;
				System.out.println(i+" "+Arrays.toString(tempArr));
				queue.add(new Permutation(i, tempArr));
			}
		}
	}
}

