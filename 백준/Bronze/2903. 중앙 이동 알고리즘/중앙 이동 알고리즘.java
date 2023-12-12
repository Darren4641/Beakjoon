import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int temp = 1;
        int num = 2;
        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(i == 1) {
                num += 1;
            }else {
                temp *= 2;
                num += temp;

            }

        }
        bw.write(num * num + "");
        bw.close();
    }
}
