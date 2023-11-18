package backjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj2559 {
    public static int[] arr;
    public static boolean[] visited;
    public static int answer = 0;
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //온도
        N = Integer.parseInt(st.nextToken());
        //날짜 수
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println();
        int sum = 0;
        //슬라이딩 윈도우
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            if(i == K - 1) {
                answer = sum;
            }

            if(i >= K) {
                sum -= arr[i - K];
                answer = Math.max(answer, sum);
            }
        }
        bw.write(answer + "");
        bw.close();
    }

}
