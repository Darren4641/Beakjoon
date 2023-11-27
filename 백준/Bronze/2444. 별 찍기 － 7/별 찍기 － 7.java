import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int size = 2 * N - 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i * 2 - 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < N - i; j++)
                System.out.print(" ");
            for(int j = 0; j < i * 2 - 1; j++)
                System.out.print("*");
            System.out.println();
        }

        bw.close();
    }
}
