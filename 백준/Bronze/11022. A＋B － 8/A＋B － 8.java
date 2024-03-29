import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long T = Integer.parseInt(br.readLine());
        long round = T;
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            bw.write("Case #" + (round - T) + ": " + A + " + " + B + " = " + (A + B) + "\n");

        }

        bw.close();
    }
}
