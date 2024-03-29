import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            else map.put(clothes[i][1], 1);
        }
        
        
        Iterator<String> iter = map.keySet().iterator();
        String key;
        while(iter.hasNext()) {
            key = iter.next();
            System.out.println(map.get(key));
            answer *= map.get(key) + 1;
        }
        
        return answer - 1;
    }
}