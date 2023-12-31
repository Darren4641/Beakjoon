import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        198 + 1 + 9 + 8 = 216

        int N = Integer.parseInt(br.readLine());
        boolean isAnswer = false;
        for(int i = 1; i < N; i++) {
            int answer = i;
            int temp = i;
            int cnt = String.valueOf(answer).length();
            for(int j = 0; j < cnt; j++) {
                answer += String.valueOf(temp).charAt(j) - '0';
            }
            if(N == answer) {
                isAnswer = true;
                bw.write(i + "");
                break;
            }
        }
        if(!isAnswer) bw.write("0");
        bw.close();
    }
}