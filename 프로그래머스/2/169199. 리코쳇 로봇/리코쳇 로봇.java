import java.util.*;

class Solution {
    
    public static boolean[][] visited;
    public static String[][] map;
    
    public static int[] drow = {-1, 1, 0, 0};
    public static int[] dcol = {0, 0, -1, 1};
    
    
    static class Pos {
        int row;
        int col;
        int level;
        
        public Pos(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        visited = new boolean[board.length][board[0].length()];
        map = new String[board.length][board[0].length()];
        Pos start = null;
        Pos end = null;
        for(int i = 0; i < board.length; i++) {
            String b = board[i];
            for(int j = 0; j < b.length(); j++) {
                map[i][j] = String.valueOf(b.charAt(j));
                if(map[i][j].equals("R")) {
                    start = new Pos(i, j, 0);
                }else if(map[i][j].equals("G")) {
                    end = new Pos(i, j, 0);
                }
            }
            
        }
        
        return move(start, end);
    }
    
    public int move(Pos start, Pos end) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.row][start.col] = true;
        
        while(!queue.isEmpty()) {
            Pos current = queue.poll();
            int row = current.row;
            int col = current.col;
            int level = current.level;
            
            if(row == end.row && col == end.col) return level;
            
            for(int i = 0; i < 4; i++) {
                int dashRow = row;
                int dashCol = col;
                
                //벽 끝이나 맵 끝 일 때 까지 전진
                while(dashRow + drow[i] >= 0 && dashRow + drow[i] < map.length && dashCol + dcol[i] >= 0 && dashCol + dcol[i] < map[0].length
                     && !map[dashRow + drow[i]][dashCol + dcol[i]].equals("D")) {
                    dashRow += drow[i];
                    dashCol += dcol[i];
                }
                
                if(!visited[dashRow][dashCol]) {
                    visited[dashRow][dashCol] = true;
                    queue.offer(new Pos(dashRow, dashCol, level + 1));
                }
                
            }
        }
        return -1;
    }

    
    
}