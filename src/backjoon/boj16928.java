package backjoon;

import java.io.*;
import java.util.*;

public class boj16928 {
    public static int[] ladderAndSnake;
    public static boolean[] visited;
    public static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ladderAndSnake = new int[101];
        visited = new boolean[101];
        count = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladderAndSnake[a] = b;
        }
        BFS();

        bw.write(count[100] + "");
        bw.close();
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        count[1] = 0;
        visited[1] = true;

        while(!queue.isEmpty()) {
            int position = queue.poll();

            if(position == 100) return;

            for(int i = 1; i < 7; i++) {
                int x = position + i;
                if(x > 100) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if(!visited[ladderAndSnake[x]] && ladderAndSnake[x] != 0) {
                    queue.offer(ladderAndSnake[x]);
                    visited[ladderAndSnake[x]] = true;
                    count[ladderAndSnake[x]] = count[position] + 1;
                }else {
                    queue.offer(x);
                    count[x] = count[position] + 1;
                }
            }

        }
    }

}
