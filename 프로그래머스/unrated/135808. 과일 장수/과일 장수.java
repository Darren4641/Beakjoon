import java.util.*;

class Solution {
    /*
    * k : 사과 최대 점수
    * m : 한 상자에 들어가는 사과 수
    * p * m : 한 상자 가격
    * score : 사과 점수들
    */
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        int cnt = 0;
        for(int i = score.length - 1; i >= 0; i--) {
            cnt++;
            if(cnt == m) {
                answer += score[i] * m;
                cnt = 0;
            }
        }
        return answer;
    }
    
    
}