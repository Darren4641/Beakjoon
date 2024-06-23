import java.util.*;

class Solution {
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = makeKeyMinMap(keymap);
        
        int index = 0;
        for(String target : targets) {
            int count = 0;
            char[] charArray = target.toCharArray();           
            for(char c : charArray) {
                if(map.get(c) == null) {
                    count = 0;
                    break;
                } else {
                    count += map.get(c);
                }
            }
            answer[index] = count != 0 ? count : -1;
            index++;
        }
            
        return answer;
    }
    
    private Map<Character, Integer> makeKeyMinMap(String[] keymap) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(String keyword : keymap) {
            char[] key = keyword.toCharArray();
            int index = 1;
            for(char c : key) {
                if(map.get(c) == null) {
                    map.put(c, index);
                } else {
                    map.put(c, Math.min(index, map.get(c)));
                }
            
                index++;
            }
        }
        return map;
    }
    
    
}