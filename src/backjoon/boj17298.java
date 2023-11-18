package backjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            while(!s.isEmpty() && A[s.peek()] < A[i]) {
                answer[s.pop()] = A[i];
            }
            s.push(i);
        }

        while(!s.isEmpty())
            answer[s.pop()] = -1;

        for(int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.close();
    }
}
