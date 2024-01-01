import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] num = new Integer[N];
        int index = 0;
        st = new StringTokenizer(br.readLine());

        while(N-- > 0) {
            num[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num, (o1, o2) -> o2 - o1);
        bw.write(num[k - 1] + "");
        bw.close();
    }
}