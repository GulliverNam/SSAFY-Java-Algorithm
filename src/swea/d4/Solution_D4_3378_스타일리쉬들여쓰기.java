package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기 {
	
	static ArrayDeque<int[]> allRCS = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		fillRCS(0, new int[3]);
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int count[] = new int[3];
			ArrayDeque<int[]> RCS = new ArrayDeque<>(allRCS);
			for (int i = 0; i < p; i++) {
				boolean check = true;
				int indent = 0;
				for (char c : br.readLine().trim().toCharArray()) {
					if(check) {
						if(c == '.') indent++;
						else{
							if(count[0]+count[1]+count[2] > 0) {
								for (int j = 0, size = RCS.size(); j < size; j++) {
									int cur[] = RCS.poll();
									if(cur[0]*count[0] + cur[1]*count[1] + cur[2]*count[2] != indent)
										continue;
									RCS.offer(cur);
								}
							}
							check = false;
						}
					}
					switch(c) {
						case '(': count[0]++; break;
						case ')': count[0]--; break;
						case '{': count[1]++; break;
						case '}': count[1]--; break;
						case '[': count[2]++; break;
						case ']': count[2]--; break;
					}
				}
			}
			Arrays.fill(count, 0);
			bw.write("#"+tc+" ");
			
			int rcs[] = RCS.poll();
			int temp[] = rcs;
			if(RCS.size() > 0)
				temp = RCS.pollLast();
			
			for (int i = 0; i < q; i++) {
				int result = 0, comp = 0;
				for (int j = 0; j < 3; j++) {
					result += count[j]*rcs[j];
					comp += count[j]*temp[j];
				}
				if(result != comp)
					bw.write("-1 ");
				else
					bw.write(result+" ");
				for (char c : br.readLine().trim().toCharArray()) {
					switch(c) {
						case '(': count[0]++; break;
						case ')': count[0]--; break;
						case '{': count[1]++; break;
						case '}': count[1]--; break;
						case '[': count[2]++; break;
						case ']': count[2]--; break;
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void fillRCS(int idx, int nums[]) {
		if(idx == 3) {
			allRCS.offer(nums.clone());
			return;
		}
		for (int i = 1; i <= 20; i++) {
			nums[idx]=i;
			fillRCS(idx+1,nums);
		}
		
	}

}
