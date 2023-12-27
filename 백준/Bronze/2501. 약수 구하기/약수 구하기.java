import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= A; i++) {
            if(A % i == 0) {
                list.add(i);
            }
        }
        Collections.sort(list);
        if(list.size() < B) bw.write("0");
        else bw.write(list.get(B-1) + "");
        bw.close();
    }

    public static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
