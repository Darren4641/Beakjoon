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
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, cnt = 0;
        int startIndex = 0, endIndex = 0;
        while(true) {
            
            if(sum >= M) {
                sum -= arr[startIndex++];
            }else if(endIndex == N) {
                break;
            }else {
                sum += arr[endIndex++];
            }
            if(sum == M) {
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.close();
    }
}
