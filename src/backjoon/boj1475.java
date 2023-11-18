package backjoon;

import java.io.*;

public class boj1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[10];
        String N = br.readLine();

        for(int i = 0; i < N.length(); i++) {
            int current = N.charAt(i) - '0';
            if(current == 6 && num[6] > num[9]) num[9]++;
            else if(current == 9 && num[9] > num[6]) num[6]++;
            else num[current]++;
        }
        int answer = 0;
        for(int i = 0; i < num.length; i++) {
            answer = Math.max(answer, num[i]);
        }
        bw.write(answer + "");
        bw.close();
    }
}
