package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_5658_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb, tmp;
		int T = Integer.parseInt(br.readLine().trim());
		int N, K, lotateNum;
		long num;
		ArrayList<Long> nums = new ArrayList<Long>(28);
		String str;
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			lotateNum = N/4;
			sb = new StringBuilder(N);
			tmp = new StringBuilder(lotateNum + 2);
			str = br.readLine().trim();
			for (int i = 0; i < lotateNum; i++) {
				for (int j = 0; j < 4; j++) {
					tmp.append("0x").append(str.substring(j*lotateNum, (j+1)*lotateNum));
					num = Long.decode(tmp.toString());
					if(!nums.contains(num))
						nums.add(num);
					tmp.delete(0, N);
				}
				sb.append(str.substring(N-1, N)).append(str.substring(0, N-1));
				str = sb.toString();
				sb.delete(0, N);
			}
			nums.sort(new Comparator<Long>() {
				@Override
				public int compare(Long o1, Long o2) {
					return (int)(o1 - o2);
				}
			});
			System.out.println("#"+testCase+" "+nums.get(K-1));
			nums.clear();
		}
	}

}
