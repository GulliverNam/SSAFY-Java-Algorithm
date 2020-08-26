package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1251_하나로_Prim {
	
	static int xy[][];
    static double node[][];
    static double tax;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            xy = new int[n][2];
            node = new double[n][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int i = 0; i < n; i++) {
                    xy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            tax = Double.parseDouble(br.readLine().trim());
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    node[i][j] = node[j][i] = getCost(i,j);
                }
            }
            boolean check[] = new boolean[n];
            double key[] = new double[n];
            int p[] = new int[n];
            Arrays.fill(key, Double.MAX_VALUE);
            key[0] = 0;
            p[0] = -1;
            for (int i = 0; i < n-1; i++) {
                double min = Double.MAX_VALUE;
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if(!check[j] && key[j] < min) {
                        min = key[j];
                        index = j;
                    }
                }
                check[index] = true;
                for (int j = 0; j < n; j++) {
                    if(!check[j] && node[index][j] != 0 && key[j] > node[index][j]) {
                        p[j] = index;
                        key[j] = node[index][j];
                    }
                }
            }
            double answer = 0;
            for (int i = 0; i < n; i++) {
                answer += key[i];
            }
            bw.write(String.format("#%d %.0f\n", tc, answer));
        }
        bw.flush();
        bw.close();
    }
     
    private static double getCost(int from, int to) {
        return tax * (Math.pow(xy[from][0] - xy[to][0],2) + Math.pow(xy[from][1] - xy[to][1], 2));
    }
	
}
