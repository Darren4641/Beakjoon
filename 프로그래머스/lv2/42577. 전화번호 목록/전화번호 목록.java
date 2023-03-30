import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for(String p : phoneBook) 
            map.put(p, 0);
        
        for(String p : phoneBook) {
            for(int j = 0; j < p.length(); j++) {
                if(map.containsKey(p.substring(0, j)))
                    return false;
            }
        }

        return true;
    }
}