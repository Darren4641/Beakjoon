import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            sum += in - out;
            max = Math.max(max, sum);
        }
        bw.write(max + "");
        bw.close();
    }
}
