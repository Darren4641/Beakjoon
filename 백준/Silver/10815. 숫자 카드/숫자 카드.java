import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Long, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            map.put(array[i], 1);
        }

        int M = Integer.parseInt(br.readLine());
        long[] find = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(map.containsKey(Long.parseLong(st.nextToken())))
                bw.write(1 + " ");
            else bw.write(0 + " ");
        }
        bw.close();
    }
}
