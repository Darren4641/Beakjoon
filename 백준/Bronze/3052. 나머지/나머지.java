import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[1001];

        for(int i = 0; i < 10; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k % 42] = 1;
        }
        int sum = 0;
        for(int a : arr) {
            sum += a;
        }
        bw.write(sum + "");
        bw.close();
    }
}
