import java.util.*;

class Solution {
    public static final int A = 97;
    public static final int Z = 122;
    public String solution(String s, String skip, int index) {
        String answer = "";
        Map<Character, Integer> skipMap = new HashMap<>();
            
        for(int i = 0; i < skip.length(); i++) {
            char c = skip.charAt(i);
            skipMap.put(c, getASCII(c));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            sb.append(encCharacter(c, index, skipMap));        
        }
    
        return sb.toString();
    }
    
    public Character encCharacter(Character c, int index, Map<Character, Integer> skipMap) {
        int indexValue = getASCII(c);
        int start = 1;
        while(start <= index) {
            indexValue++;
            if(indexValue > Z) {
                indexValue = A;
            }
            if(skipMap.get((char) indexValue) == null) {
                start++;
            }
            
        }
        
        return (char) indexValue;
    }
    
    private int getASCII(char c) {
        return (int) (c);
    }
}