import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Toss1 {
    public static boolean[] visit;
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String case1 = "1451232125";
        
        int N = 2;
        visit = new boolean[N + 1];

        for(int i = 0; i < case1.length() - N + 1; i++) {
            String num = case1.substring(i, N + i);
            pq.add(checkNum(num, N));
        }

        while(!pq.isEmpty() && pq.peek()  > 1000) {
            pq.poll();
        }

        System.out.println(pq.peek());
    }
    public static int checkNum(String num, int N) {
        int now;
        int cnt = 0;
        for(int k = 0; k < num.length(); k++) {
            now = num.charAt(k)-'0';
            for(int i = 1; i <= N; i++) {
                if(!visit[i] && i == now) {
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        if(cnt == N) {
            for(int i = 1; i < visit.length; i++) {
                if(visit[i])
                    return Integer.parseInt(num);
            }
        }else {
            Arrays.fill(visit, false);
        }
        return -1;
    }

}
