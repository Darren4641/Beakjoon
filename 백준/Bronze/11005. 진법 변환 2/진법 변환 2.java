import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(N > 0) {
            long temp = N % B;
            if(temp < 10) sb.append((char) (temp + '0'));
            else sb.append((char) ((temp - 10) + 'A'));
            N /= B;
        }

        bw.write(sb.reverse().toString() + "");
        bw.close();
    }
}
