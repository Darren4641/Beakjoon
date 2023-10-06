import java.util.*;

class Solution {
    
    static class Mineral {
        int diamond;
        int iron;
        int stone;
        
        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] scoreBoard = new int[][] { {1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int picksSum = Arrays.stream(picks).sum();
        List<Mineral> list = new ArrayList<>();
        
        for(int i = 0; i < minerals.length; i+=5) {
            if(picksSum == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;
                
                String current = minerals[j];
                int val = current.equals("iron") ? 1 : 
                current.equals("stone") ? 2 : 0;
                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }
            list.add(new Mineral(dia, iron, stone));
            picksSum -= 1;
        }
        
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
        
        for(Mineral m : list) {
            if(picks[0] > 0) {
                answer += m.diamond;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += m.iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += m.stone;
                picks[2]--;
                continue;
            }
        }
        
        return answer;
    }
}