import java.io.*;
import java.util.*;

public class Main {
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};
    static int[][] house;
    static int cnt;
    static boolean[][] visited;
    public static void solution(int[][] house, int size) {
        List<Integer> countList = new ArrayList<>();
        visited = new boolean[size][size];

        int dong = 1;
        //전체 탐색
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!visited[i][j] && house[i][j] == 1) {
                    cnt = 0;
                    DFS(i, j, size, dong++);
                    countList.add(cnt);
                }
            }
        }

        Collections.sort(countList);
        System.out.println(dong-1);
        for(int count : countList) {
            System.out.println(count);
        }
    }

    public static void DFS(int x, int y, int size, int dong) {
        visited[x][y] = true;
        house[x][y] = dong;
        cnt++;
        int wx, wy;
        for(int i = 0; i < 4; i++) {
            wx = x + dx[i];
            wy = y + dy[i];
            if(isWay(wx, wy, size) && !visited[wx][wy] && house[wx][wy] == 1) {
                DFS(wx, wy, size, dong);
            }
        }

    }

    public static boolean isWay(int x, int y, int size) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            house = new int[size][size];

            StringTokenizer st;
            String temp;
            for(int i = 0; i < size; i++) {
                temp = br.readLine();
                for(int j = 0; j < size; j++) {
                    house[i][j] = temp.charAt(j) - '0';
                }
            }
            solution(house, size);
        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}
