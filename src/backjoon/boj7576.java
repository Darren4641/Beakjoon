package backjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj7576 {

    public static int N;
    public static int M;
    public static int[][] box;
    public static Deque<int[]> deque;
    public static int[] drow = {-1, 1, 0, 0};
    public static int[] dcol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];
        deque = new ArrayDeque();
        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) deque.addLast(new int[] { i, j });
            }
        }


        bfs();
        int answer = getResult();
        bw.write(answer == 1 ? "0" : answer + "");
        bw.close();
    }

    public static int getResult() {
        int max = 0;
        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N; j++) {
                if (box[i][j] == 0) return -1;
                max = Math.max(max, box[i][j]);
            }
        }
        return max - 1;
    }

    public static void bfs() {

        while(!deque.isEmpty()) {
            int[] index = deque.removeFirst();

            for(int i = 0; i < 4; i++) {
                int curRow = index[0] + drow[i];
                int curCol = index[1] + dcol[i];

                if(!isWay(curRow, curCol)) continue;

                if(box[curRow][curCol] == 0) {
                    deque.addLast(new int[] {curRow, curCol});
                    box[curRow][curCol] = box[index[0]][index[1]] + 1;
                }
            }
        }
    }

    public static boolean isWay(int row, int col) {
        return (row >= 0 && row < M) && (col >= 0 && col < N);
    }
}
