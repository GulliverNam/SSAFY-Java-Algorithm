package jungol.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_1810_백설공주2 {
	
	static int n = 9, r = 7, target = 100;
	static int[] nums, result;
	
	/**
	 * 난쟁이 조합을 구할 method
	 * @param cnt	배열번호
	 * @param start	조합의 시작 수
	 * @param sum	cnt번째까지의 난쟁이 모자 숫자 합
	 */
	public static void combination(int cnt, int start, int sum) {
		if(cnt == r) {
			if(sum == target)
				for (int i : result)
					System.out.println(i);
			return;
		}
		for(int i = start; i < n; i++) {
			result[cnt] = nums[i];
			combination(cnt + 1, i + 1, sum + result[cnt]);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1810_백설공주.txt"));
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("8 6 5 1 37 30 28 22 36");
		nums = new int[n];
		result = new int[r];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		combination(0, 0, 0);
		sc.close();
	}

}
