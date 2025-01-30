import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int currentPoint = 0;
        for(int i = 0; i < targets.length; i++) {
            int[] target = targets[i];
            if(currentPoint <= target[0]) {
                answer++;
                currentPoint = target[1];
            }
        }
        
        return answer;
    }
}