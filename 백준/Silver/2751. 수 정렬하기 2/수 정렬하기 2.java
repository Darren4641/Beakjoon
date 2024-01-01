import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int index = 0;

        while(N-- > 0) {
            num[index++] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        for(int n : num) bw.write(n + "\n");
        bw.close();
    }
}