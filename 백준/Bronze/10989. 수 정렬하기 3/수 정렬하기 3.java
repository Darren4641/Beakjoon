import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int index = 0;
        while(N-- > 0) {
            arr[index++] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int a : arr) bw.write(a + "\n");

        bw.close();
    }
}