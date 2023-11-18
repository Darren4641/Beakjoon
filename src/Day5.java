import java.io.*;
import java.util.StringTokenizer;

public class Day5 {
    public static int front = 0;
    public static int left = 90;
    public static int bottom = 180;
    public static int right = 270;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String walk = br.readLine();
            bw.write( turtleWalk(walk) + "\n");
        }
        bw.close();
    }

    public static int turtleWalk(String walk) {
        int minRow = 0, minCol = 0;
        int maxRow = 0, maxCol = 0;
        int row = 0, col = 0;
        boolean flag = true;
        int status = front;
        for(int i = 0; i < walk.length(); i++) {
            char now = walk.charAt(i);
            if(now == 'F') {
                if(status == front) {
                    col++;
                }else if(status == bottom) {
                    col--;
                }else if(status == left) {
                    row--;
                }else if(status == right) {
                    row++;
                }
            }else if(now == 'L') {
                status += 90;
                if(status == 360) status = front;
            }else if(now == 'R') {
                status -= 90;
                if(status == -90) status = right;
            }else if(now == 'B') {
                if(status == front) {
                    col--;
                }else if(status == bottom) {
                    col++;
                }else if(status == left) {
                    row++;
                }else if(status == right) {
                    row--;
                }

            }
            minRow = Math.min(minRow, row);
            minCol = Math.min(minCol, col);
            maxRow = Math.max(maxRow, row);
            maxCol = Math.max(maxCol, col);


        }


        return (maxRow - minRow) * (maxCol - minCol);
    }


}
