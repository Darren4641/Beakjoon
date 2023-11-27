import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        boolean isPall = true;
        for(int i = 0; i < sb.length() / 2; i++) {
            if(s.charAt(i) != sb.toString().charAt(i)) {
                isPall = false;
                bw.write("0");
                break;
            }
        }
        if(isPall) bw.write("1");

        bw.close();
    }
}
