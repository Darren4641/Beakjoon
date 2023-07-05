import java.util.*;

class Solution {
    public static int[] siso = {2, 3, 4};
    
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        Arrays.sort(weights);
        for(int i = 0; i < weights.length; i++) {
            double a = weights[i] * 1;
            double b = (weights[i] * 2.0) / 3.0;
            double c = (weights[i] * 1.0) / 2.0;
            double d = (weights[i] * 3.0) / 4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        return answer;
    }
    
    
}