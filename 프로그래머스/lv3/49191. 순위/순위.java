class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] array = new int[n + 1][n + 1];
        
        for(int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            array[lose][win] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(array[i][k] == 1 && array[k][j] == 1)
                        array[i][j] = 1;
                }
            }
        }       
        
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(array[i][j] == 1 || array[j][i] == 1) cnt++;
            }
            if(cnt == (n - 1)) answer++;
        }
        return answer;
    }
    
}