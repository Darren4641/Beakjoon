package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        long[] answer = new long[2];
        long max = Long.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            int start = i + 1;
            int end = N - 1;
            while(start <= end) {
                int mid = (start+end) / 2;

                long sum = array[i] + array[mid];
                if(Math.abs(sum) < max) {
                    answer[0] = array[i];
                    answer[1] = array[mid];
                    max = Math.abs(sum);
                }

                if(sum < 0) start = mid + 1;
                else end = mid - 1;
            }
        }
        bw.write(answer[0] + " " + answer[1] + "");
        bw.close();
    }
}
