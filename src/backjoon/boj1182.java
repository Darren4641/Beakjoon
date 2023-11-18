package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj1182 {

    public static int[] num;
    public static boolean[] visited;
    public static int size;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        cnt = 0;
        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];

        for(int i = 0; i < num.length; i++) {
            BT(0, i + 1, 0);
        }

        bw.write(cnt + "");
        bw.close();
    }

    public static void BT(int index, int depth, int sum) {
        if(depth == 0) {
            if(sum == size) cnt++;
            return;
        }

        for(int i = index; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                BT(i + 1, depth - 1, sum + num[i]);
                visited[i] = false;
            }
        }
    }
}
