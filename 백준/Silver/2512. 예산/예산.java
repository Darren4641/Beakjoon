import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //전체 국가 예싼 485
        //4개 지방 예산 120, 110, 140, 150
        //0 ~ 150
        // mid = 75


        //상한액 127
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0, right = -1;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        while(left <= right) {
            int mid = (left + right) / 2;

            int temp = 0;

            for(int i = 0; i < N; i++) {
                if(arr[i] > mid) temp += mid;
                else temp += arr[i];
            }
            if(temp <= M) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        bw.write(right + "");
        bw.close();

        //120 + 110 + 140 + 150 = 520
    }
}
