import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        boolean[][] time = new boolean[book_time.length][1450];
        boolean isFull;
        
        Arrays.sort(book_time, ((String[] o1, String[] o2) -> {
             if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                else
                    return o1[0].compareTo(o2[0]);   
        }));
        
        for(int i = 0; i < book_time.length; i++) {
            String[] room = book_time[i];
            for(int j = 0; j < time.length; j++) {
                isFull = false;
              for(int k = getMinutes(room[0]); k < getMinutes(room[1]) + 10; k++) {
                if(time[j][k]) {
                    isFull = true;
                    break;
                }else {
                    isFull = false;
                    time[j][k] = true;  
                }
              }
                if(!isFull) break;
            }
        }
        
        for(int i = 0; i < time.length; i++) {
            for(int j = 0; j < time[i].length; j++) {
                if(time[i][j]) {
                    answer++;
                    break;
                    
                }
            }
        }
        
        
        return answer;
    }
    
    private int getMinutes(String time) {
        String[] temp = time.split(":");
        return (Integer.parseInt(temp[0]) * 60) + Integer.parseInt(temp[1]);
    }
}