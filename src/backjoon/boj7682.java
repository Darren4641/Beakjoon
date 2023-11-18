package backjoon;

import java.io.*;

public class boj7682 {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int index = 1;
        while(true) {
            String temp = br.readLine();
            if(temp.equals("end")) break;

            board = new char[3][3];
            int idx = 0;
            int xCnt = 0;
            int oCnt = 0;
            boolean isFull = true;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    board[i][j] = temp.charAt(idx);
                    if(board[i][j] == 'X') xCnt++;
                    else if(board[i][j] == 'O') oCnt++;
                    if(board[i][j] == '.') isFull = false;
                    idx += 1;

                }
            }
            if(xCnt < oCnt || (xCnt - oCnt) > 1) {
                bw.write("invalid\n");
                index += 1;
                continue;
            }

            boolean xResult, oResult;
            xResult = isValid('X');
            oResult = isValid('O');

            if(xResult && oResult) bw.write("invalid\n"); //승자가 두명일 때
            else if(xResult && (xCnt - oCnt) != 1) bw.write("invalid\n");
            else if(oResult && xCnt != oCnt) bw.write("invalid\n");
            else if(!isFull && !xResult && !oResult) bw.write("invalid\n");
            else bw.write("valid\n");

        }
        bw.close();

    }
    ///.XX
    ///X.X
    ///OOO
    public static boolean isValid(char mark) {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) return true;
            if(board[0][i] == mark && board[1][i] == mark && board[2][i] == mark) return true;
        }
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) return true;
        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) return true;

        return false;
    }


}
