package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {

	public static boolean check[] = new boolean[20];
	public static int scores[], cals[];
	public static int N;
	public static int maxCal;
	public static int answer;
	public static int numDfs;
	
	public static int dfs(int cal_sum, int score_sum) {
		System.out.println("numDfs "+numDfs++);
		if(answer < score_sum) {
			answer = score_sum;
			return 0;
		}else {
			for(int i=0;i<N;i++) {
				if(!check[i] && cal_sum+cals[i] < maxCal) {
					check[i] = true;
					dfs(cal_sum + cals[i], score_sum + scores[i]);
					check[i] = false;
				}
			}
			return 0;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_5215_햄버거다이어트.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            maxCal = sc.nextInt();
            scores = new int[N];
            cals = new int[N];
            answer = 0;
            for(int i = 0; i < N;i++) {
            	scores[i] = sc.nextInt();
            	cals[i] = sc.nextInt();
            }
            dfs(0,0);
            System.out.println("#"+test_case+" "+answer);
		}
	}

}
