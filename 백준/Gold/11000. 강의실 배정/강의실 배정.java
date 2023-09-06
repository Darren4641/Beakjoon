
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, (s1, s2) -> {
            if(s1[0] == s2[0]) return s1[1] - s2[1];
            return s1[0] - s2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(data[0][1]);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= data[i][0]) pq.poll();
            pq.add(data[i][1]);
        }
        bw.write(pq.size() + "");
        bw.close();
    }
}
