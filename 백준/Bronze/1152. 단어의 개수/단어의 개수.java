import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String context = br.readLine();
        String[] words = context.split(" ");
        int cnt = 0;
        for(String w : words) {
            if(w.length() != 0) cnt += 1;
        }
        bw.write(cnt + "");

        bw.close();
    }
}
