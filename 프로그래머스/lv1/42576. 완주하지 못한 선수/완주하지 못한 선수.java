import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> part = new HashMap<String, Integer>();
        
        String answer = "";
        
        for(String p : participant) {
            if(!part.containsKey(p))
                part.put(p, 1);
            else
                part.put(p, part.get(p) + 1);
        }
            
         for(String c : completion) {
             if(part.containsKey(c))
                 part.put(c, part.get(c) - 1);
         }
        
        for(String k : part.keySet()) {
            if(part.get(k) != 0)
                answer = k;
        }
        
        
        return answer;
    }
    

}