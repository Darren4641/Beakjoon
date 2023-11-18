import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

public class Practice1 {

    public static String[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        star = new String[N][N];
        partition(0, 0, N, false);
        //012
        //345
        //678
        //System.out.println(Arrays.deepToString(star));
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
    }

    //0 0 9

    //0 0 3
    //0 3 6
    //0 6 9

    //3 0 3
    //3 3 6
    //3 6 9

    //6 0 3
    //6 3 6
    //6 6 9

    public static void partition(int row, int col, int size, boolean blank) {
       if(blank) {
           for(int i = row; i < row + size; i++) {
               for(int j = col; j < col + size; j++) {
                   star[i][j] = " ";
               }
           }
           return;
       }

       if(size == 1) {
           star[row][col] = "*";
           return;
       }
       int div = size / 3;
       int cnt = 0;
       for(int i = row; i < row + size; i += div) {
           for(int j = col; j < col + size; j += div) {
                cnt++;
                if(cnt == 5)  {
                    partition(i, j, div, true);
                }else
                    partition(i, j, div, false);
           }
       }
    }
}
