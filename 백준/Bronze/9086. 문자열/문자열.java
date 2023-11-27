import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb;
        while(T-- > 0) {
            String word = br.readLine();
            sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.charAt(word.length() - 1));
            bw.write(sb.toString() + "\n");
        }


        bw.close();
    }
}
