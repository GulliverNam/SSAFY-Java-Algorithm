package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_배열check {
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1861_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, room[][], length, max, answer;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			length = N*N;
			room = new int[length][3];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					room[i*N+j] = new int[] {i, j , Integer.parseInt(st.nextToken())};
				}
			}
			
			Arrays.sort(room, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			max = 0;
			answer = 0;
			int cnt = 1, sn = room[0][2];
			for (int i = 1; i < length; i++) {
				if(Math.abs(room[i-1][0] - room[i][0])+Math.abs(room[i-1][1] - room[i][1]) == 1) {
					cnt++;
				} else {
					if(max < cnt) {
						max = cnt;
						answer = sn;
					}
					else if(max == cnt)
						answer = Math.min(answer, sn);
					cnt = 1;
					sn = room[i][2];
				}
			}
			if(answer == 0 && max == 0) {
				max = cnt;
				answer = sn;
			}
			
			
			System.out.println("#"+testCase+" "+answer+" "+max);
		}
	}
}
