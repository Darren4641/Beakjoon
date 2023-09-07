import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[] mbti;
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            mbti = new String[N];
            for(int k = 0; k < N; k++) {
                mbti[k] = st.nextToken();
            }
            if(N > 32) {
                bw.write("0\n");
                continue;
            }

            int answer = 12;
            for(int a = 0; a < N; a++) {
                for(int b = a + 1; b < N; b++) {
                    for(int c = b + 1; c < N; c++) {
                        int value = 0;
                        value += getFriendCount(mbti[a], mbti[b]);
                        value += getFriendCount(mbti[b], mbti[c]);
                        value += getFriendCount(mbti[a], mbti[c]);
                        answer = Math.min(answer, value);
                    }
                }
            }

            bw.write(answer + "\n");
        }
        bw.close();

    }

    public static int getFriendCount(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt;
    }

}
