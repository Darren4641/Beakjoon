
class Solution {
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int p = getPower(i);
            if(p > limit) p = power;
            answer += p;
        }
        return answer;
    }
    
    private int getPower(int num) {
        int cnt = 0;
        for(int i = 1; i * i <= num; i++) {
            if(i*i == num) cnt += 1;
            else if(num % i == 0) cnt += 2;
        }
        return cnt;
    }
}