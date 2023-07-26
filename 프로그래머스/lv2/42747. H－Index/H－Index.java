import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        //length = 5
        // 2 : 3
        // 0 1 3 5 6
        
        int max = citations[citations.length - 1];
        int temp;
        for(int i = max; i >= 0; i--) {
            temp = 0;
            for(int j = 0; j < citations.length; j++) {
                if(i <= citations[j]) {
                    temp++;
                    
                }       
            }
            
        
            
            if(temp >= i) {
                
                answer = Math.max(answer, i);
                
            }
                       
        }
        
        
        return answer;
    }
}