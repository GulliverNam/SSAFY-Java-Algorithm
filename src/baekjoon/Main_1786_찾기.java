package baekjoon;

import java.io.*;

public class Main_1786_찾기 {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      char[] t = br.readLine().toCharArray();
      char[] p = br.readLine().toCharArray();
      int tLength = t.length;
      int pLength = p.length;
      int[] pi = new int[pLength];
     
      int j = 0;
      for(int i = 1; i < pLength; i++) {
         while(j>0&&p[i]!=p[j]) {
            j = pi[j-1];
         }
         if(p[i]==p[j]) {
            pi[i] = ++j;
         }
      }
      
      j = 0;
      int cnt = 0;
      for(int i = 0; i < tLength; i++) {
         while(j>0&&p[j]!=t[i]) {
            j = pi[j-1];
         }
         if(p[j] == t[i]) {
            if(j == pLength-1) {
               cnt++;
               sb.append((i-pLength+2)+" ");
               j = pi[j];
            }
            else j++;
         }
      }
      
      sb.insert(0,cnt+"\n");
      bw.write(sb.toString());
      bw.flush();
      bw.close();
   }
}