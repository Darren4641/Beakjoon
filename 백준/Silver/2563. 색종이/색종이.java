

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static String[][] temp = new String[100][100];
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] paper = new int[N];

        int row, col;
        for(int i = 0; i < paper.length; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            draw(row, col, temp);
        }

        bw.write(cnt + "");
        bw.close();

    }

    public static void draw(int row, int col, String[][] temp) {
        boolean flag = false;
        for(int i = col; i < 10 + col; i++) {
            for(int j = row; j < 10 + row; j++) {
                if(temp[i][j] == null) {
                    temp[i][j] = "O";
                    cnt++;
                }
            }
        }
    }
}
