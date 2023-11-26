import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            basket[i] = i;
        }
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
        }

        for(int i = 1; i <= N; i++) {
            bw.write(basket[i] + " ");
        }
        bw.close();
    }
}
