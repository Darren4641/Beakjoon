import java.util.*;

class Solution {
    public static String[][] map;
    public static boolean[][] visited;
    public static int[] dashRow = { -1, 1, 0, 0};
    public static int[] dashCol = { 0, 0, -1, 1};
    public static int day = 0;
    public int[] solution(String[] maps) {
        int[] answer = {};
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
            }
            
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                DFS(i, j);
                if(day != 0)
                    list.add(day);
                day = 0;
            }
        }
        if(list.isEmpty()) return new int[] { -1 };
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void DFS(int row, int col) {
        if(map[row][col].equals("X")) return;
        if(visited[row][col]) return;
        
        visited[row][col] = true;
        day += Integer.parseInt(map[row][col]);
        for(int i = 0; i < 4; i++) {
            int drow = dashRow[i] + row;
            int dcol = dashCol[i] + col;
            if(drow < 0 || drow >= map.length || dcol < 0 || dcol >= map[0].length) {
                continue;
            }
            if(!map[drow][dcol].equals("X") && !visited[drow][dcol]) {
                DFS(drow, dcol); 
            }
        }
        
    }
}