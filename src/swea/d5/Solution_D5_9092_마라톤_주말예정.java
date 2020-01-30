package swea.d5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution_D5_9092_마라톤_주말예정 {
	
	static int N, K, points[][], distance[][];
	static List<ArrayList<Integer>> select;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_9092_마라톤.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(), length;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			K = sc.nextInt();
			points = new int[N][2];
			length = (N-1-K)*(K+1) + (K)*(K+1)/2;
			distance = new int[length][3];
			select = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N; i++) {
				points[i][0] = sc.nextInt();
				points[i][1] = sc.nextInt();
			}
			
			System.out.println("#"+testCase);
			int cnt = 0;
			for (int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					if(j < i+K+2) {
						distance[cnt][0] = i;
						distance[cnt][1] = j;
						distance[cnt++][2] = getDistance(i,j);
					}
					else break;
				}
			}
			
			Arrays.sort(distance, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			ArrayList<Integer> temp;
			int flag = 0;
			for (int i = 0; i < length; i++) {
				temp = new ArrayList<Integer>();
				for (int j = 0; j < args.length; j++)
					temp.add(distance[i][j]);					
				if(cycleCheck() || kCheck())
					continue;
				else if(isFinish()) {
					break;
				}
				else
					select.add(temp);
			}
			
		}
		
		sc.close();
	}
	
	

	private static boolean isFinish() {
		// TODO Auto-generated method stub
		return false;
	}



	private static boolean kCheck() {
		// TODO Auto-generated method stub
		return false;
	}



	private static boolean cycleCheck() {
		// TODO Auto-generated method stub
		return false;
	}



	private static int getDistance(int i, int j) {
		return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
	}

}
