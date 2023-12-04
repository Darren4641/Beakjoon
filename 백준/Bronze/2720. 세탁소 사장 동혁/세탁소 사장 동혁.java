import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int money = Integer.parseInt(br.readLine());

            bw.write(money / 25 + " ");
            money %= 25;
            bw.write(money / 10 + " ");
            money %= 10;
            bw.write(money / 5 + " ");
            money %= 5;
            bw.write(money + " ");

            bw.write("\n");
        }
        bw.close();
    }
}
