package swea.d5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_D5_9092_마라톤_주말예정 {
	
	static int N, K, points[][], distance[][][], Answer;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_9092_마라톤.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(), length;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			K = sc.nextInt();
			points = new int[N][2];
			Answer = Integer.MAX_VALUE;
			distance = new int[N-1][][];
			for (int i = 0; i < N; i++) {
				points[i][0] = sc.nextInt();
				points[i][1] = sc.nextInt();
			}
			
			int idx, k = 0;
			for (int i = 0; i < N-1; i++) {
				length = i < N-1-K ? K+1 : K+1-(++k);
				distance[i] = new int[length][2];
				idx = 0;
				for (int j = i+1; j <= i+length; j++) {
					distance[i][idx][0] = j;
					distance[i][idx++][1] = getDistance(i, j);
				}
			}
			
			for (int i = 0; i < N-1; i++) {
				Arrays.sort(distance[i], new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
			            return Integer.compare(o1[1], o2[1]);
			        }
				});
			}
			
			findShortestPath(0,0,0);
			System.out.println("#"+testCase+" "+Answer);
			
			
		}
		
		sc.close();
	}
	
	private static void findShortestPath(int s, int d, int k) {
		if(s == N-1) {
			Answer = Math.min(Answer, d);
			return;
		}
		int nk;
		for (int i = 0; i < distance[s].length; i++) {
			nk = distance[s][i][0] - s - 1;
			if(nk+k > K)
				continue;
			findShortestPath(distance[s][i][0], d+distance[s][i][1], k+nk);
//			if(Answer != Integer.MAX_VALUE)
//				return;
		}
	}

	private static int getDistance(int i, int j) {
		return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
	}

	
}
