package swea.d3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
 
public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String args[]) throws Exception
    {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_3307_최장증가부분수열.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int array[] = new int[N];
            int max_length[] = new int[N];
            Arrays.fill(max_length, 1);
            int answer = 0;
            for(int i=0;i<N;i++) array[i] = sc.nextInt();
             
            for(int i=0;i<N;i++)
                for(int j=i+1;j<N;j++)
                    if(array[i] < array[j] && max_length[j] <= max_length[i])
                        max_length[j] += 1;
 
            for(int i=0;i<N;i++) answer = Math.max(answer, max_length[i]);
            System.out.println("#"+test_case+" "+answer);
        }
    }

}
