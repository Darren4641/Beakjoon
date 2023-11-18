package backjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();
        String num = br.readLine();

        for(int i = 0; i < N; i++) {
            //1231234
            int curNum = num.charAt(i) - '0';
            while(!deque.isEmpty() && K != 0 && deque.getLast() < curNum) {
                deque.removeLast();
                K--;
            }
            deque.addLast(curNum);
        }

        while(deque.size() > K) {
            bw.write(deque.removeFirst() + "");
        }
        bw.close();
    }

}
