import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] visited;
    public static int[] drow = {-1, 1, 0 ,0};
    public static int[] dcol = {0, 0, -1, 1};
    public static int answer = 0;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[][] trash = new String[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];

        //초기화
        for(int i = 0; i <= row; i++) {
            Arrays.fill(trash[i], ".");
        }

        //쓰레기 위치
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trash[r][c] = "#";
        }

        //탐색
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(trash[i][j].equals("#")) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        cnt = 1;
                        DFS(i, j, trash);
                        answer = Math.max(answer, cnt);
                    }

                }
            }
        }
        bw.write(answer + "");
        bw.close();
    }

    public static void DFS(int row, int col, String[][] trash) {
        for(int i = 0; i < 4; i++) {
            int dashRow = row + drow[i];
            int dashCol = col + dcol[i];
            if(dashRow < 0 || dashCol < 0 || dashRow >= trash.length || dashCol >= trash[0].length)
                continue;
            if(!visited[dashRow][dashCol] && trash[dashRow][dashCol].equals("#")) {
                visited[dashRow][dashCol] = true;
                cnt++;
                DFS(dashRow, dashCol, trash);
            }
        }

    }
}
