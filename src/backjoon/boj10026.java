package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj10026 {

public static String[][] pic;
public static boolean[][] visited;
public static int cnt = 0;
public static int[] drow = {0,0,-1,1};
public static int[] dcol = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer1 = 0;
        int answer2 = 0;
        int N = Integer.parseInt(br.readLine());
        pic = new String[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < N; j++) {
                pic[i][j] = String.valueOf(temp.charAt(j));
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    answer1++;
                    visited[i][j] = true;
                    DFS(i, j, pic[i][j]);
                }
            }
        }
        bw.write(answer1 + " ");

        changeColor();

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    answer2++;
                    visited[i][j] = true;
                    DFS(i, j, pic[i][j]);
                }
            }
        }
        bw.write(answer2 + "");
        bw.close();
    }

    public static void changeColor() {
        for(int i = 0; i < pic.length; i++) {
            for (int j = 0; j < pic[0].length; j++) {
                if(pic[i][j].equals("G")) pic[i][j] = "R";
            }
        }
    }
    public static void DFS(int row, int col, String color) {
        for(int i = 0; i < 4; i++) {
            int r = row + drow[i];
            int c = col + dcol[i];

            if(isWay(r, c) && !visited[r][c]) {
                if(color.equals(pic[r][c])) {
                    visited[r][c] = true;
                    DFS(r, c, color);
                }
            }
        }
    }

    public static boolean isWay(int row, int col) {
        return (row < pic.length && row >= 0) && (col < pic[0].length && col >= 0);
    }
}
