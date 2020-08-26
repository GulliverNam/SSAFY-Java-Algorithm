package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
 
public class Solution_D4_7701_염라대왕의이름정렬 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> names = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    for (int i = 0; i < s1.length(); i++) {
                        if(s1.charAt(i) != s2.charAt(i))
                            return s1.charAt(i) - s2.charAt(i);
                    }
                }
                return s1.length() - s2.length();
            }
        });
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                String str = br.readLine().trim();
                if(!names.contains(str))
                    names.add(str);
            }
            bw.write("#"+tc+"\n");
            Iterator<String> iter = names.iterator();
            while(iter.hasNext()) {
                bw.write(iter.next()+"\n");
            }
            names.clear();
        }
        bw.flush();
        bw.close();
    }
     
}