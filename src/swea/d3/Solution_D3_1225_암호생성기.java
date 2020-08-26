package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1225_암호생성기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> strs = new LinkedList<>();
		for (int testCase = 1; testCase <= 10; testCase++) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 8; i++)
				strs.add(Integer.parseInt(st.nextToken()));

			int tmp = 1;
			int i = 0, cur;
			while(tmp > 0) {
				i = (i % 5) + 1;
				cur = strs.poll() - i;
				tmp = cur > 0 ? cur : 0;
				strs.add(tmp);
			}
			System.out.print("#"+testCase+" ");
			for (i = 0; i < 8; i++)
				System.out.print(strs.get(i)+" ");
			System.out.println();
			strs.clear();
		}
	}

}
