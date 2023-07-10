import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long min = 1;
        long max = (long) n * times[times.length - 1];
        long mid;
        long sum;
        while(min <= max) {
            mid = (min + max) / 2;
            sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];
                
            }
            if(sum >= n) {
                answer = mid;
                max = mid - 1;
            }else
                min = mid + 1;
        }
        
        return answer;
    }
}