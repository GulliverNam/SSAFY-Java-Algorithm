package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1828_냉장고.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		int material[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			material[i][0] = Integer.parseInt(st.nextToken());
			material[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(material, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] > o2[1])
					return 1;
				else if(o1[1] == o2[1])
					return 0;
				return -1;
			}
		});
		
		int answer = 1;
		int max = material[0][1];
		for (int i = 1; i < N; i++) {
			if(max < material[i][0]) {
				max = material[i][1];
				answer++;
			}
		}
		System.out.println(answer);
		

	}

}
