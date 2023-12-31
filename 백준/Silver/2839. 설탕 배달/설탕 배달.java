import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //3kg 5kg
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean isAnswer = false;
        while(true) {
            if(N == 0) {
                isAnswer = true;
                break;
            }
            if(N < 3) {
                break;
            }
            if(N % 5 == 0) {
                answer += N / 5;
                N %= 5;
            }else {
                N -= 3;
                answer += 1;
            }
        }


        if (isAnswer) {
            bw.write(answer + "");
        } else {
            bw.write("-1");
        }
        bw.close();
    }
}