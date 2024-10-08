import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        //한 원에 들어올 수 있는 점 갯수 구하기
        
        
        // y = 루트(r^2 - x^2)
        // y = 루트(4 - 0) = 2
        // y = 루트(4 - 1) = 루트3 = 1.7x
        // y = 루트(4 - 4) = 루트3 = 1.7x
        // i = x 라 가정
        
        double r1pow = Math.pow(r1, 2);
        double r2pow = Math.pow(r2, 2);
        
        for(int i = 1; i <= r2; i++) {
            double xpow = Math.pow(i, 2);
            long minPoint = (long) Math.ceil(Math.sqrt(r1pow - xpow));
            long maxPoint = (long) Math.floor(Math.sqrt(r2pow - xpow));
            
            answer += maxPoint - minPoint + 1;
        }
        
        return answer * 4;
    }
    
    
}