import java.util.*;

class Solution {
    
    static class ArrayItem {
        int startIndex;
        int endIndex;

        public ArrayItem(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        List<ArrayItem> arrayItems = new ArrayList<>();
        
        while(true) {
            if(sum == k)  {
                arrayItems.add(new ArrayItem(left, right));
            }
            
            if(left == sequence.length && right == sequence.length) break;
            
            if(sum <= k && right < sequence.length) {
                right++;
                if(right < sequence.length) sum += sequence[right];
            } else {
                if(left < sequence.length) sum -= sequence[left];
                left++;
            }
        }
        
        Collections.sort(arrayItems, (o1, o2) -> {
            if(Math.abs(o1.startIndex - o1.endIndex) == Math.abs(o2.startIndex - o2.endIndex)) 
                return o1.startIndex - o2.startIndex;
            else return Math.abs(o1.startIndex - o1.endIndex) - Math.abs(o2.startIndex - o2.endIndex);
        });
        
        return new int[] {arrayItems.get(0).startIndex, arrayItems.get(0).endIndex};
    }
    
    private Boolean isRange(int startIndex, int endIndex, int length) {
        return startIndex >= 0 && startIndex < length && endIndex >= 0 && endIndex < length;
    }
}