package backjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj9205 {
    public static int N;
    public static int sx, sy, ex, ey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            List<int[]> list = new LinkedList<>();
            for(int k = 0; k < N+2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(k == 0) {
                    sx = x;
                    sy = y;
                }else if(k == N+1) {
                    ex = x;
                    ey = y;
                }else {
                    list.add(new int[] {x, y});
                }
            }
            bw.write(BFS(list) ? "happy\n" : "sad\n");
        }
        bw.close();
    }

    public static boolean BFS(List<int[]> list) {
        Deque<int[]> deque = new LinkedList<>();
        boolean[] visited = new boolean[N];
        deque.addLast(new int[] {sx, sy});

        while(!deque.isEmpty()) {
            int[] pos = deque.removeFirst();
            int px = pos[0], py = pos[1];

            if(Math.abs(px - ex) + Math.abs(py - ey) <= 1000)
                return true;

            for(int i = 0; i < N; i++) {
                int[] store = list.get(i);
                if(!visited[i] && Math.abs(px - store[0]) + Math.abs(py - store[1]) <= 1000) {
                    visited[i] = true;
                    deque.addLast(new int[] {store[0], store[1]});
                }
            }
        }
        return false;
    }
}
