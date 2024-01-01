import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int index = 0;
        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            arr[index++] = num;
        }
        Arrays.sort(arr);
        for(int n : arr) bw.write(n + "\n");
        bw.close();
    }
}