package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    sum = card[i] + card[j] + card[k];
                    if(sum <= M) {
                        answer = Math.max(sum, answer);
                    }
                }
            }
        }
        bw.write(answer + "");
        bw.close();
    }
}
