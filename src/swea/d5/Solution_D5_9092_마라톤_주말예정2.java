package swea.d5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution_D5_9092_마라톤_주말예정2 {
	
	static int N, K, points[][], distance[][], Answer;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_9092_마라톤.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(), length;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			K = sc.nextInt();
			points = new int[N][2];
			length = (N-1-K)*(K+1) + K*(K+1)/2;
			distance = new int[length][3];
			for (int i = 0; i < N; i++) {
				points[i][0] = sc.nextInt();
				points[i][1] = sc.nextInt();
			}
			
			int idx = 0, max;
			for (int i = 0; i < N-1; i++) {
				max = i < N-1-K ? K+1+i : N-1;
				for (int j = i+1; j <= max; j++) {
					System.out.println(i+" "+j);
					distance[idx][0] = i;
					distance[idx][1] = j;
					distance[idx++][2] = getDistance(i, j);
				}
			}
			
			Arrays.sort(distance, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
		            return Integer.compare(o1[2], o2[2]);
		        }
			});
			
			for (int i = 0; i < length; i++) {
				System.out.println(Arrays.toString(distance[i]));
			}
			
			System.out.println("#"+testCase+" "+Answer);
			
			
		}
		
		sc.close();
	}
	
//	private static void findShortestPath(int s, int d, int k) {
//		if(s == N-1) {
//			Answer = Math.min(Answer, d);
//			return;
//		}
//		int nk;
//		for (int i = 0; i < distance[s].length; i++) {
//			nk = distance[s][i][0] - s - 1;
//			if(nk+k > K)
//				continue;
//			findShortestPath(distance[s][i][0], d+distance[s][i][1], k+nk);
////			if(Answer != Integer.MAX_VALUE)
////				return;
//		}
//	}

	private static int getDistance(int i, int j) {
		return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
	}

	
}
