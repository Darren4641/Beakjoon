import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //낮에 A미터 올라감.
        //밤에는 B미터 미끄러짐.
        //정상에서는 안 미끄러짐
        //A, B, V
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());//올라감
        int B = Integer.parseInt(st.nextToken());//미끄러짐
        int V = Integer.parseInt(st.nextToken());//정상

        int day = (V - B) / (A - B);
        if((V - B) % (A - B) != 0) day++;
        bw.write(day + "");
        bw.close();
    }
}
