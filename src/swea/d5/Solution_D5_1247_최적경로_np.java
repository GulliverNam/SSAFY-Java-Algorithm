package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_np {
	
	static int N, p[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_1247_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			int customers[][] = new int[N][2]; // N명의 고객집 좌표
			int distance[][] = new int[N+2][2]; // 회사 좌표(0), N명의 고객좌표(순열로 순서 결정:1~N), 집좌표(N+1)
			p = new int[N];
			int answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine().trim());
			distance[0] = new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			distance[N+1] = new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			for (int i = 0; i < N; i++) {
				customers[i] = new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
				p[i] = i+1;
			}
			// p배열 = {1,2,3, ... ,N}
			do {
				for (int i = 0; i < N; i++)
					distance[p[i]] = customers[i];
				int temp = 0;
				for (int i = 0; i < N+1; i++) {
					if(temp >= answer) break;
					temp = Math.abs(distance[i][0] - distance[i+1][0]) + Math.abs(distance[i][1] - distance[i+1][1]);
				}
				answer = Math.min(answer, temp);
			}while(nextPermutation());
			System.out.println("#"+tc+" "+answer);
		}
	}

	/**
	 * Create permutation
	 * @return true: possible next permutation / false: impossible next permutation
	 */
	private static boolean nextPermutation() {
		// 1. 뒤쪽부터 탐색하며 꼭대기(i) 찾기 : i-1 => 교환위치
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) --i;
		if(i == 0) return false; // 이미 제일 큰 마지막 순열이므로 false retrun
		
		// 2. 뒤쪽부터 탐색하며 교환할 큰값(j) 찾기
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		// 3. i-1, j위치 교환
		int temp = p[j];
		p[j] = p[i-1];
		p[i-1] = temp;
		
		// 4. i위치 부터 N-1(맨뒤)까지 내림차순형태의 숫자를 오름차순으로 가장 작은수로 만들기 위해 정렬
		int k = N-1;
		while(i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		return true;
	}

}
