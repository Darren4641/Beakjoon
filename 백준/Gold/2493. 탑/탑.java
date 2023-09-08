
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N + 1];

        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            while(!stack.empty()) {
                if(stack.peek()[1] >= top[i]) {
                    answer[i] = stack.peek()[0];
                    break;
                }
                stack.pop();
            }
            if(stack.empty()) {
                answer[i] = 0;
            }
            stack.push(new int[] {i, top[i]});
        }
        for(int i = 1; i <= N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.close();
    }
}
