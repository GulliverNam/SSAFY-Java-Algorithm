package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9655_돌게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int a = (N / 3)% 2;
		int b = (N % 3)% 2;
		if((a ^ b) == 1)
			System.out.println("SK");
		else
			System.out.println("CY");
	}		

}
