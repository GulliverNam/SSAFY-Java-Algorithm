package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_D4_1233_사칙연산유효성검사 {

	static LinkedList<Character> Stack = new LinkedList<>();
	static String treeList[];
	static int N, Answer;
	static char c;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1233_사칙연산유효성검사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringTokenizer st;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			treeList = new String[N+1];
			Answer = 1;
			
			for (int i = 0; i < N; i++) {
				// 입력 형태
				//	- 번호 data 왼쪽번호 오른쪽번호
				st = new StringTokenizer(br.readLine(), " ");
				treeList[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			postOrder(1);
			
			if(!Stack.isEmpty()) Stack.pop();
			else Answer = 0;
			if(!Stack.isEmpty()) Answer = 0;
			
			System.out.println("#"+testCase+" "+Answer);
			Stack.clear();
		}
		
	}
	
	public static void postOrder(int i) {
		if(i<<1 <= N) postOrder(i<<1);
		if((i<<1)+1 <= N) postOrder((i<<1)+1);
		char c = treeList[i].charAt(0);
		if(c >= '0' && c <= '9')
			Stack.push(c);
		else {
			if(!checkStack()) Answer = 0;
		}
	}
	
	public static boolean checkStack() {
		char n1, n2;
		if(!Stack.isEmpty())
			n1 = Stack.pop();
		else
			return false;

		if(!Stack.isEmpty())
			n2 = Stack.pop();
		else
			return false;
		Stack.push(n1);
		return true;
	}

}
