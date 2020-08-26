package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_4408_자기방으로돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, a, b;
		LinkedList<int[]> queue = new LinkedList<>(); 
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				a = (Integer.parseInt(st.nextToken()) - 1) / 2;
				b = (Integer.parseInt(st.nextToken()) - 1) / 2;
				queue.offer(new int[] {Math.min(a, b), Math.max(a, b)});
			}
			
			queue.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			int answer = 0;
			while(!queue.isEmpty()) {
				int max =queue.poll()[1];
				int length = queue.size();
				int room[];
				for (int i = 0; i < length; i++) {
					room = queue.poll();
					if(max >= room[0])
						queue.offer(new int[] {room[0],room[1]});
					else
						max = room[1];
				}
				answer++;
			}
			System.out.println("#"+testCase+" "+answer);
			queue.clear();
		}
		
	}

}
