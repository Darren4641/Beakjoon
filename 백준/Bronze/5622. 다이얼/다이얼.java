import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dial = {"0", "WXYZ", "TUV", "PQRS", "MNO", "JKL", "GHI", "DEF", "ABC", "1", " ", " "};
        String word = br.readLine();
        int answer = 0;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for(int j = 0; j < dial.length; j++) {
                if(dial[j].indexOf(c) != -1) {
                    answer += (dial.length) -j - 1;
                    break;

                }
            }
        }
        bw.write(answer + "");

        bw.close();
    }
}
