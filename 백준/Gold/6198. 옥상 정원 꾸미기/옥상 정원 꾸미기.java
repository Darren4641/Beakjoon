
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        Stack<int[]> stack = new Stack<>();
        long sum = 0;
        for(int i = 1; i <= N; i++) {
            while(!stack.isEmpty() && stack.peek()[1] <= building[i])
                stack.pop();
            stack.push(new int[] {i, building[i]});
            sum += stack.size() - 1;

        }

        bw.write(sum + "");
        bw.close();
    }
}
