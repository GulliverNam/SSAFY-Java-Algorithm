package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {

	static int n, length, answer, remain;
	static char[] nums;
	static Character[] maxNum;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			nums = st.nextToken().toCharArray();
			length = nums.length;
			maxNum = new Character[length];
			for (int i = 0; i < length; i++) {
				maxNum[i] = nums[i];
			}
			Arrays.sort(maxNum, new Comparator<Character>() {
				@Override
				public int compare(Character o1, Character o2) {
					return o2 - o1;
				}
			});
			n = Integer.parseInt(st.nextToken());
			answer = 0;
			dfs(0, 0);
			boolean count[] = new boolean[10];
			boolean dup = false;
			if(remain > 0) {
				for (int i = 0; i < length; i++) {
					if(!count[nums[i] - '0'])
						count[nums[i] - '0'] = true;
					else {
						dup = true;
						break;
					}
				}
				if(!dup && remain % 2 == 1) {
					int one = answer % 10;
					int two = answer / 10 % 10;
					answer = answer - (answer % 100) + (one*10 + two);
				}
			}
			
			System.out.println("#"+testCase+" "+answer);
			
		}

	}

	private static boolean dfs(int start, int cnt) {
		if(isMax()) {
			answer = Math.max(answer, Integer.parseInt(String.valueOf(nums)));
			remain = n - cnt;
			return false;
		}
		if(cnt == n) {
			answer = Math.max(answer, Integer.parseInt(String.valueOf(nums)));
			return true;
		}
		for (int i = start; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
				swap(i,j);
				dfs(i+1,cnt+1);
				swap(i,j);
			}
		}
		return true;
	}

	private static boolean isMax() {
		for (int i = 0; i < nums.length; i++)
			if(nums[i] != maxNum[i])
				return false;
		return true;
	}

	private static void swap(int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
