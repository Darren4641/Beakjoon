import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(isCorrect(s)) answer++;
            
            s = leftRotate(s);
        }
        
        return answer;
    }
    
    public String leftRotate(String s) {
        char leftChar = s.charAt(0);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(leftChar);
        
        return sb.toString();
    }
    
    public Boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        
        if((s.charAt(0) == '}') || (s.charAt(0) == ')') || (s.charAt(0) == ']')) {
            return false;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if(current == '{' || current == '(' || current == '[') {
                stack.push(current);
            } else if(!stack.isEmpty()) {
                switch(stack.peek()) {
                    case '{':
                        if(current == '}') {
                            stack.pop(); 
                            break;
                        } else return false;
                    case '(':
                        if(current == ')') {
                            stack.pop(); 
                            break;
                        } else return false;
                    case '[':
                        if(current == ']') {
                            stack.pop(); 
                            break;
                        } else return false;
                    default: return false;
                }
            }
            
        }
        
        return stack.size() == 0;
    }
}