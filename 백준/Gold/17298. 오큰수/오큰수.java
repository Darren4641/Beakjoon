
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> s = new Stack<>();
        int[] answer = new int[N + 1];
        for(int i = 0; i < N; i++) {

            while(!s.isEmpty() && s.peek()[1] < A[i]) {
                answer[s.pop()[0] + 1] = A[i];
            }

            s.push(new int[] {i, A[i]});
        }

        while(!s.isEmpty()) {
            int[] p = s.pop();
            answer[p[0] + 1] = -1;
        }
        for(int i = 1; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.close();
    }
}
