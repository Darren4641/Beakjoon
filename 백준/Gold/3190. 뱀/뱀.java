
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        StringTokenizer st;
        int appleCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }


        Deque<int[]> queue = new LinkedList<int[]>();
        //시작 위치
        queue.addLast(new int[] {1, 1});
        int d = 0;
        int time = 0;
        boolean isEnd = false;
        Map<Integer,String> moveInfo = new HashMap<>();
        int moveCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < moveCount; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            moveInfo.put(X, C);
        }

        while (true) {
            time += 1;
            if(queue.peek() != null) {
                int rx = queue.getLast()[0] + dx[d];
                int ry = queue.getLast()[1] + dy[d];

                if(rx < 1 || ry < 1 || rx > N || ry > N) {
                    break;
                }

                if(queue.stream().anyMatch(pos -> pos[0] == rx && pos[1] == ry)) {
                    break;
                }

                if(board[rx][ry] == 1) {
                    queue.addLast(new int[] {rx, ry});
                    board[rx][ry] = 0;
                }else {
                    queue.addLast(new int[] {rx, ry});
                    queue.removeFirst();
                }
            }
            if(moveInfo.containsKey(time)) {
                if(moveInfo.get(time).equals("L")) d = (d + 3) % 4;
                else d = (d + 1) % 4;
            }
        }

        bw.write(time + "");
        bw.close();

    }
}
