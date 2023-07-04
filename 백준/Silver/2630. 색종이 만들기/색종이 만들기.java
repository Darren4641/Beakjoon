import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int white = 0;
    public static int blue = 0;
    public static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        num = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        partition(0, 0, N);
        bw.write(white + "\n");
        bw.write(blue + "");
        bw.close();
    }

    public static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(num[row][col] == 0) white++;
            else blue++;
            return;
        }
        int half = size / 2;
        partition(row, col, half);
        partition(row, col + half, half);
        partition(row + half, col, half);
        partition(row + half, col + half, half);
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = num[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(color != num[i][j]) return false;
            }
        }
        return true;
    }
}
