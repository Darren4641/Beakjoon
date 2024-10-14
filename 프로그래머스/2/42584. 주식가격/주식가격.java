import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            
            while(!stack.isEmpty() && currentPrice < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }
        return answer;
    }
}

// 1, 2, 3, 2, 3

// [0, 1, 3]

/*
* 0
* 1
* 2 = 3-2 = 1
* 3 = 
* 4 = 5-4-1 = 0
*/
