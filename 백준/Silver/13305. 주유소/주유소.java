import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] way = new int[N - 1];
        int[] oil = new int[N];
        for(int i = 0 ; i < N - 1; i++) {
            way[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = oil[0];
        for(int i = 0; i < way.length; i++) {
            if(min > oil[i])
                min = oil[i];
            sum += min * way[i];
        }
        bw.write(sum + "");
        bw.close();
    }

}
