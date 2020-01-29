package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1208_Flatten.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		int arr[], dump;
		
		for (int testCase = 1; testCase < T+1; testCase++) {
			dump = sc.nextInt();
			arr = new int[100];
			for(int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			for(int i = 0; i < dump; i++) {				
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			System.out.println("#"+testCase+" "+(arr[99]-arr[0]));
		}
		sc.close();
	}
}