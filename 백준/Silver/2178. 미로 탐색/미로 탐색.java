import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] way;
    static boolean[][] visited;
    static int N;
    static int M;
    public static final int POSITION = 4;
    public static final int[] X_POSITION = {0, -1, 1, 0};
    public static final int[] Y_POSITION = {-1, 0, 0, 1};
    // 위 = x, y - 1
    // 왼 = x - 1, y
    // 아 = x + 1, y
    // 오 = x, y + 1

    public static void solution() {
        visited = new boolean[N][M];

        BFS(0, 0);
        System.out.println(way[N - 1][M - 1]);
    }

    public static void BFS(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] now;
        int dashX, dashY;
        visited[x][y] = true;
        deque.add(new int[] {x, y});
        while(!deque.isEmpty()) {
            now = deque.removeFirst();
            for(int i = 0; i < POSITION; i++) {
                dashX = now[0] + X_POSITION[i];
                dashY = now[1] + Y_POSITION[i];
                if(isWay(dashX, dashY)) {
                    if(way[dashX][dashY] != 0 && !visited[dashX][dashY]) {
                        visited[dashX][dashY] = true;
                        deque.addLast(new int[] {dashX, dashY});
                        way[dashX][dashY] = way[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }

    public static boolean isWay(int x, int y) {
        if(x >= 0 && y >= 0 && x < N && y < M)
            return true;
        return false;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            way = new int[N][M];
            String data;
            int temp;
            for(int i = 0; i < N; i++) {
                data = br.readLine();
                for(int j = 0; j < data.length(); j++) {
                    temp = data.charAt(j) - '0';
                    way[i][j] = temp;
                }

            }
            solution();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
