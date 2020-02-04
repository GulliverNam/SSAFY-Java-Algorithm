package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_5603_건초더미 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_5603_건초더미.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int N, nums[], originNum;
		int answer;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			nums = new int[N];
			originNum = 0;
			answer = 0;
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(br.readLine().trim());
				originNum += nums[i];
			}
			originNum /= N;
			Arrays.sort(nums);
			int tmp;
			for (int i = 0; i < N; i++) {
				tmp = nums[i] - originNum;
				if(tmp >= 0) break;
				answer -= tmp;
			}
			System.out.println("#"+testCase+" "+answer);
		}
		
	}

}
