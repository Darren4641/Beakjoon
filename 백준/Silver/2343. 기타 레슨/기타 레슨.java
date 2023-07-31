
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 0;
        int answer = 99999;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.max(arr[i], min);
            max += arr[i];
        }

        while(min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;
            int sum = 0;
            for(int a : arr) {
                if((sum + a) <= mid) sum += a;
                else {
                    cnt++;
                    sum = a;
                }
            }
            if(sum != 0) cnt++;
            if(cnt > M) min = mid + 1;
            else max = mid - 1;

        }

        bw.write(min + "");
        bw.close();

    }
}
