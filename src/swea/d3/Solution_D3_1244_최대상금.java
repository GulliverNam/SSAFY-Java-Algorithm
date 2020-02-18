package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {

	static int n, length, answer;
	static char[] nums;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			nums = st.nextToken().toCharArray();
			length = nums.length;
			n = Integer.parseInt(st.nextToken());
			answer = 0;
			dfs(0, 0);
			System.out.println("#"+testCase+" "+answer);
			
		}

	}

	private static void dfs(int start, int cnt) {
		if(cnt == n) {
			answer = Math.max(answer, Integer.parseInt(String.valueOf(nums)));
			return;
		}
		for (int i = start; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
				if(nums[i] <= nums[j]) {
					swap(i,j);
					dfs(i,cnt+1);
					swap(i,j);
				}
			}
		}
	}

	private static void swap(int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
