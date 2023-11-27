import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String left = st.nextToken();
        String right = st.nextToken();
        StringBuilder reverseLeft = new StringBuilder();
        StringBuilder reverseRight = new StringBuilder();
        for(int i = left.length() - 1; i >= 0; i--) {
            reverseLeft.append(left.charAt(i));
        }

        for(int i = right.length() - 1; i >= 0; i--) {
            reverseRight.append(right.charAt(i));
        }

        bw.write(Math.max(Integer.parseInt(reverseLeft.toString()), Integer.parseInt(reverseRight.toString())) + "");

        bw.close();
    }
}
