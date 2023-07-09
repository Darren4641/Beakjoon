import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(solve(N) + "");
        bw.close();

    }

    public static int solve(int N) {
        int M;
        for(int i = 1; i <= N; i++) {
            M = i;
            for(int j = 0; j < String.valueOf(i).length(); j++) {
                M += String.valueOf(i).charAt(j) - '0';
            }
            if(M == N)
                return i;
        }

       return 0;
    }
}
