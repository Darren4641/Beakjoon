package backjoon;

import java.io.*;
import java.util.*;

public class boj16928_1 {
    static int N, M;
    static int[] arr, count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[101];
        count = new int[101];
        visited = new boolean[101];

        for(int ladder = 0; ladder < N; ladder++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            arr[col] = row;
        }

        for(int snake = 0; snake < M; snake++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            arr[col] = row;
        }

        bfs();
        bw.write(count[100] + "");
        bw.close();

    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        count[1] = 0;
        visited[1] = true;
        while(!queue.isEmpty()) {
            int index = queue.poll();

            if(index == 100) return;

            for(int dice = 1; dice < 7; dice++) {
                int dash = index + dice;
                if(dash > 100) continue;
                if(visited[dash]) continue;
                visited[dash] = true;

                if(arr[dash] != 0) {
                    if(!visited[arr[dash]]) {
                        queue.offer(arr[dash]);
                        visited[arr[dash]] = true;
                        count[arr[dash]] = count[index] + 1;
                    }
                }else {
                    queue.offer(dash);
                    count[dash] = count[index] + 1;
                }

            }

        }
    }

}
