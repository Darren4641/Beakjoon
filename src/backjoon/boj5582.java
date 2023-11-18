package backjoon;

import java.io.*;
import java.util.Arrays;

public class boj5582 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S1 = br.readLine();
        String S2 = br.readLine();

        int len_S1 = S1.length();
        int len_S2 = S2.length();
        int answer = 0;
        int[][] map = new int[len_S1 + 1][len_S2 + 1];

        for(int i = 1; i <= len_S1; i++) {
            for(int j = 1; j <= len_S2; j++) {
                if(S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        bw.write(answer + "");
        bw.close();

    }
}
