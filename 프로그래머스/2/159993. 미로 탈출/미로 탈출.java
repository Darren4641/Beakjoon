import java.util.*;

class Solution {
    public static String[][] miro;
    public static boolean[][] visited;
    public static int[][] count;
    public static int[] dashRow = { -1, 1, 0, 0};
    public static int[] dashCol = { 0, 0, -1, 1};
    public static int answer = 0;
    public int solution(String[] maps) {
        miro = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        count = new int[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lebber = new int[2];
        int[] end = new int[2];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                miro[i][j] = String.valueOf(maps[i].charAt(j));
                if(miro[i][j].equals("S")) {
                    start[0] = i;
                    start[1]  = j;
                }
                if(miro[i][j].equals("L")) {
                    lebber[0] = i;
                    lebber[1] = j;
                }
                if(miro[i][j].equals("E")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        answer += bfs(start, lebber);
        if(answer != -1) {
            visited = new boolean[maps.length][maps[0].length()];
            count = new int[maps.length][maps[0].length()];
            int add = bfs(lebber, end);
            if(add != -1) 
                answer += add;
            else return add;
        }else 
            answer = -1;
        return answer;
    }
    
    public int bfs(int[] start, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            if(row == target[0] && col == target[1]) {
                return count[row][col];
            }
            for(int i = 0; i < 4; i++) {
                int drow = row + dashRow[i];
                int dcol = col + dashCol[i];
                
                if(drow < 0 || drow >= miro.length || dcol < 0 || dcol >= miro[0].length) continue;
                
                if(!visited[drow][dcol] && !miro[drow][dcol].equals("X")) {
                    visited[drow][dcol] = true;
                    count[drow][dcol] = count[row][col] + 1;
                    queue.offer(new int[] { drow, dcol });
                }
            }
            
        }
        return -1;   
    }
    

}