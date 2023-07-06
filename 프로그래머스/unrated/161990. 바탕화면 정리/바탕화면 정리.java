import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        
        int min_row = 51;
        int min_col = 51;
        int max_row = 0;
        int max_col = 0;
        
        String[][] temp = new String[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                temp[i][j] = String.valueOf(wallpaper[i].charAt(j));
                if(temp[i][j].equals("#")) {
                    min_row = Math.min(min_row, i);
                    min_col = Math.min(min_col, j);
                    max_row = Math.max(max_row, i);
                    max_col = Math.max(max_col, j);
                }
            }
        }
        
        int[] answer = { min_row, min_col, max_row + 1, max_col + 1};
        return answer;
    }
}