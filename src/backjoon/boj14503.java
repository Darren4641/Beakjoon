package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj14503 {

    public static int dir;
    public static int[][] room;
    public static int cnt = 0;
    public static int[] drow = {-1, 0, 1, 0};
    public static int[] dcol = {0, 1, 0, -1};
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        //0 북
        //1 동
        //2 남
        //3 서
        room = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFSS(row, col, dir);
        //process(row, col, dir);
        bw.write(cnt + "");
        bw.close();
    }



    public static void DFSS(int row, int col, int dir) {
        if(room[row][col] == 1) return;
        else if(room[row][col] == 0) {
            room[row][col] = 2;
            cnt++;
        }

        int dr = 0, dc = 0;
        for(int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            dr = row + drow[dir];
            dc = col + dcol[dir];
            if(room[dr][dc] > 0) continue;
            DFSS(dr, dc, dir);
            return;
        }

        DFSS(row - drow[dir], col - dcol[dir], dir);
        return;

    }
    
}
