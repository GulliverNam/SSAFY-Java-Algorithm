package com.ssafy.step02.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P03_NextPermutation {
   static int N;
   static int[] input;
   static int totalCnt;
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      input = new int[N];
      for (int i = 0; i < N; i++) {
         input[i] = sc.nextInt();
      }
      
      Arrays.sort(input);
      do {
//         System.out.println(Arrays.toString(input));
      } while (nextPermutation());
   }
   
   private static boolean nextPermutation() {
      //step1
      int i = N-1;
      while(i>0 && input[i-1]>=input[i]) --i;
      if(i==0) return false;
      
      //step2
      int j = N-1;
      while(input[i-1]>=input[j]) j--;
      
      //step3
      int temp = input[i-1];
      input[i-1] = input[j];
      input[j] = temp;
      
      //step4
      int k = N-1;
      while(i<k) {
         temp = input[i];
         input[i] = input[k];
         input[k] = temp;
         k--;      
      }
      return true;
   }
}