import java.io.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //소수는 약수가 1과 자기 자신 뿐인 수
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(N-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if(isSoSoo(num)) answer += 1;

        }
        bw.write(answer + "");
        bw.close();
    }

    public static boolean isSoSoo(int num) {
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
