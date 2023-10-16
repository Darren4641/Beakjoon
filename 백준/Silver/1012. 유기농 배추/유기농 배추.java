import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] field;
    static boolean[][] visited;
    static int[] dashRow = { -1, 1, 0, 0};
    static int[] dashCol = { 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            field = new int[M][N];
            visited = new boolean[M][N];
            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                field[row][col] = 1;
            }
            int answer = 0;
            for(int r = 0; r < M; r++) {
                for(int c = 0; c < N; c++) {
                    if(!visited[r][c] && field[r][c] == 1) {
                        DFS(r, c);
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }
        bw.close();

    }

    public static void DFS(int row, int col) {

        for(int i = 0; i < 4; i++) {
            int nextRow = row + dashRow[i];
            int nextCol = col + dashCol[i];

            if(nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N) continue;

            if(!visited[nextRow][nextCol] && field[nextRow][nextCol] == 1) {
                visited[nextRow][nextCol] = true;
                DFS(nextRow, nextCol);
            }
        }
    }

    private static void print() {
        for(int a = 0; a < M; a++) {
            for(int b = 0; b < N; b++) {
                System.out.print(field[a][b]);
            }
            System.out.println();
        }
    }
}
