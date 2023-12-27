import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            int sum = 0;
            for(int i = 1; i < n; i++) {
                if(n % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }
            if(sum == n) {
                bw.write(n + " = ");
                for(int i = 0; i < list.size(); i++) {
                    bw.write(list.get(i) + "");
                    if(i != list.size() - 1) bw.write(" + ");
                }
                bw.write("\n");
            }else {
                bw.write(n + " is NOT perfect.\n");
            }
            list.clear();
        }

        bw.close();
    }

    public static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
