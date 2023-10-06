class Solution {
    
    
    public int solution(int a, int b, int n) {
        int answer = 0;
        // a : 빈병
        // b : 주는 콜라병
        // n : 총 빈 병
        
        int temp = n;
        int t = 0;
        while(temp >= a) {
            n = temp;
            temp = ((n / a) * b);
            System.out.println(temp);
            answer += temp;
            if(n % a != 0) temp += n % a;
            
        }    
        return answer;
    }
}