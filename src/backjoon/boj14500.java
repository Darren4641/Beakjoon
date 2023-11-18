package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj14500 {
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int max = Integer.MIN_VALUE;
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(i, j, board[i][j], 1);
                visited[i][j] = false;
            }
        }
        bw.write(max + "");
        bw.close();

    }

    public static void DFS(int row, int col, int sum, int cnt) {
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            if(curRow < 0 || curRow >= N || curCol < 0 || curCol >= M) continue;

            if(!visited[curRow][curCol]) {
                visited[curRow][curCol] = true;
                if(cnt == 2) {
                    DFS(row, col, board[curRow][curCol] + sum, cnt + 1);
                    visited[curRow][curCol] = false;
                }
                DFS(curRow, curCol, board[curRow][curCol] + sum, cnt + 1);
                visited[curRow][curCol] = false;
            }
        }
    }



}
