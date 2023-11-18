package backjoon;

import java.io.*;

public class boj9663 {
    static int N;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = 0;
        bfs(0);
        bw.write(count + "");
        bw.close();
    }

    public static void bfs(int depth) {
        if(depth == N) {
            count += 1;
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[depth] = i;
            if(checkoutQueenIndex(depth)) {
                bfs(depth + 1);
            }
        }
    }

    public static boolean checkoutQueenIndex(int depth) {
        for(int i = 0; i < depth; i++) {
            if(arr[depth] == arr[i]) return false;
            if(Math.abs(arr[depth] - arr[i]) == Math.abs(depth - i)) return false;
        }
        return true;
    }

}
