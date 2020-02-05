package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1071_약수와배수 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1071_약수와배수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine().trim());
		int num, factor = 0, multiple = 0;
		for (int i = 0; i < n; i++) {
			num = nums[i];
			if(m % num == 0) factor += num;
			if(num % m == 0) multiple += num;
		}
		System.out.println(factor+"\n"+multiple);
	}

}
