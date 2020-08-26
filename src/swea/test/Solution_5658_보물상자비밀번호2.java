package swea.test;

import java.io.*;
import java.util.*;

public class Solution_5658_보물상자비밀번호2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String nums = br.readLine().trim();
			Set<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			int length = N/4;
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < 4; j++) {
					set.add(Integer.parseInt(nums.substring(j*length, (j+1)*length), 16));
				}
				nums = nums.substring(1) + nums.substring(0, 1);
			}
			int answer = 0;
			int cnt = 0;
			for (Integer i : set) {
				if(++cnt == K) {
					answer = i;
					break;
				}
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
