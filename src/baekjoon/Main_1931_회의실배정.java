package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_1931_회의실배정.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		int meeting[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int finish = meeting[0][1];
		int answer = 1;
		for (int i = 1; i < N; i++) {
			if(finish <= meeting[i][0]) {
				finish = meeting[i][1];
				answer++;
			}
		}
		System.out.println(answer);

	}

}
