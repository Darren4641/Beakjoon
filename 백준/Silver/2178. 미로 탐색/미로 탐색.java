import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] way;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        way = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            for(int j = 0; j < temp.length(); j++) {
                int num = temp.charAt(j) - '0';
                way[i][j] = num;
            }
        }

        dfs();
        bw.write(way[N-1][M-1] +"");
        bw.close();

    }

    public static void dfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {0,0});
        visited = new boolean[N][M];
        visited[0][0] = true;
        while(!deque.isEmpty()) {
            int[] index = deque.removeFirst();
            int row = index[0];
            int col = index[1];

            for(int i = 0; i < 4; i++) {
                int dashRow = row + drow[i];
                int dashCol = col + dcol[i];

                if((dashRow < 0 || dashRow >= N) || (dashCol < 0 || dashCol >= M)) continue;

                if(!visited[dashRow][dashCol] && way[dashRow][dashCol] != 0) {
                    visited[dashRow][dashCol] = true;
                    deque.addLast(new int[] { dashRow, dashCol });
                    way[dashRow][dashCol] = way[row][col] + 1;
                }
            }

        }
    }
}
