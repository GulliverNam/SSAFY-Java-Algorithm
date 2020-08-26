package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8275_햄스터 {

	static int N, X, M, cage[], inputs[][], max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int l, r, s;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cage = new int[N];
			inputs = new int[M][3];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				inputs[i][0] = Integer.parseInt(st.nextToken()) - 1;
				inputs[i][1] = Integer.parseInt(st.nextToken()) - 1;
				inputs[i][2] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0, new int [N]);
			
			System.out.print("#"+tc+" ");
			if(max == Integer.MIN_VALUE)
				System.out.print(-1);
			else {
				for (int i = 0; i < N; i++)
					System.out.print(cage[i]+" ");
			}
			System.out.println();
		}

	}

	private static void permutation(int cnt, int arr[]) {
		if(cnt == N) {
			if(checkCage(arr)) {
				int num = 0;
				for (int a : arr)
					num += a;
				if(max < num) {
					max = num;
					cage = arr.clone();
				}
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			arr[cnt] = i;
			permutation(cnt+1, arr);
		}
	}

	private static boolean checkCage(int arr[]) {
		for (int[] i : inputs) {
			int sum = 0;
			for (int j = i[0]; j <= i[1]; j++)
				sum += arr[j];
			if(sum != i[2])
				return false;
		}
		return true;
	}

}
