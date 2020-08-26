package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_1812_수정이의타일자르기 {
	
	static class Rectangle implements Comparable<Rectangle>{
		int min, max;

		public Rectangle(int w, int h) {
			this.min = Math.min(w, h);
			this.max = Math.max(w, h);
		}
		
		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
	}
	
	static int N, M, answer, tiles[];
	static PriorityQueue<Rectangle> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tiles = new int[N];
			answer = 0;
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				tiles[i] = Integer.parseInt(st.nextToken());
			}
			cut();
			System.out.println("#"+tc+" "+answer);
		}

	}

	private static void cut() {
		// 가장 큰 크기의 정사각형부터 만들기
		Arrays.sort(tiles);
		queue = new PriorityQueue<>();
		queue.offer(new Rectangle(M, M));
		++answer;
		
		for (int i = N-1; i > -1; i--) {
			go(1<<tiles[i]);
		}
	}

	private static void go(int size) {
		// queue에서 poll() : min값이 최대인 직사각형이 뽑아짐
		// 직사각형의 최소변의 길이가 size보다 같거나 크면: 원하는 크기의 정사각형을 만들 수 있음
		Rectangle r = queue.poll();
		if(r.min >= size) {
			queue.offer(new Rectangle(r.min-size, size));
			queue.offer(new Rectangle(r.min, r.max-size));
		}
		else { // 아니면: 원하는 크기의 정사각형을 만들 수 없음
			queue.offer(r);
			queue.offer(new Rectangle(M-size, size));
			queue.offer(new Rectangle(M, M-size));
			answer++;
		}
	}
	
}
