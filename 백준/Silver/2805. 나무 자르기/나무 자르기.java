import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int left = 0, right = -1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, tree[i]);
        }

        while(left <= right) {
            int mid = (left + right) / 2;

            long temp = 0;
            for(int i = 0; i < N; i++) {
                if(tree[i] > mid) temp += (tree[i] - mid);
            }

            if(temp >= M) left = mid + 1;
            else right = mid - 1;
        }
        bw.write(right + "");
        bw.close();
    }
}
