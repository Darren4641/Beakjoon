import java.util.*;

class Solution {
    public static boolean[] visit;
    public static List<String> allRoute;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        int cnt = 0;
        
        
        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visit[i] = false;
            }
        }
        
        
    }
    
    
}