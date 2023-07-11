import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] answer = {};
        boolean flag;
        for(int i = 0; i < prices.length; i++) {
            int time = 0;
            flag = true;
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    q.add(j-i);
                    flag = false;
                    break;
                }
                time++;
            }
            if(flag) q.add(time);
        }
        
        answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
}