import java.io.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 987654321;
        for(int i = M; i <= N; i++) {
            if(isSosoo(i)) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if(sum != 0) {
            bw.write(sum + "\n");
            bw.write(min + "");
        }else {
            bw.write("-1");
        }

        bw.close();
    }

    public static boolean isSosoo(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
