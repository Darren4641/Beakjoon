import java.util.*;

class Solution {
    List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(1, 3, 2, n);
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    
    public void hanoi(int start, int end, int mid, int n) {
        int[] move = {start, end};
        
        if(n == 1) list.add(move);
        else {
            hanoi(start, mid, end, n-1);
            list.add(move);
            hanoi(mid, end, start, n-1);
        }
    }
}