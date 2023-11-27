import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for(int j = 0; j < count; j++) {
                    bw.write(c);
                }
            }
            bw.write("\n");
        }

        bw.close();
    }
}
