package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] chess = new boolean[N][M];

        String block;

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < M; j++) {
                block = String.valueOf(temp.charAt(j));
                chess[i][j] = block.equals("W");
            }
        }
        int dx = N - 7;
        int dy = M - 7;
        int answer = 999999;
        for(int i = 0; i < dx; i++) {
            for(int j = 0; j < dy; j++) {
                answer = Math.min(getCount(i, j, chess), answer);
            }
        }

        System.out.println(answer);

    }

    public static int getCount(int x, int y, boolean[][] chess) {
        int count = 0;
        boolean first = chess[x][y];
        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if(first != chess[i][j]) count++;
                first = !first;
            }
            first = !first;
        }
        return Math.min(count, 64 - count);
    }
}
