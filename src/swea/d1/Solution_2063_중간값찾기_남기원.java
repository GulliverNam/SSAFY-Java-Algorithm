package swea.d1;

import java.util.Scanner;
import java.util.Arrays;

public class Solution_2063_중간값찾기_남기원 {

	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int nums[] = new int[T];
        for(int test_case = 1; test_case <= T; test_case++)
            nums[test_case-1] = sc.nextInt();
        Arrays.sort(nums);
        System.out.println(nums[(T+1)/2-1]);
    }

}
