import java.util.*;

class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int startBus = 540;
        int lastBus = 1440;
        //셔틀 운행횟수
        //셔틀 운행 간격
        //최대 크루 수
        
        //데크에 초단위로 타임테이블 삽입
        int crewCount = 0;
        Arrays.sort(timetable);
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < timetable.length; i++) {
            deque.addLast(getTime(timetable[i]));
        }
        
        int lastCrew = 0;
        //셔틀 운영횟수
        for(int k = 1; k <= n; k++) {
            
            //셔틀 탑승
            while(deque.peek() != null && (deque.peek() <= startBus && crewCount < m)) {
                lastCrew = deque.removeFirst();
                crewCount++;
            }
            
        
            //기다리는 사람 없는데 자리 남음
            if(deque.isEmpty() && crewCount < m) {
                answer = getStringTime(startBus);
            }
            //기다리는 사람 없는데 자리 안남음
            if(deque.isEmpty() && crewCount >= m) {
                answer = getStringTime(lastCrew - 1);
            }
            //기다리는 사람 있으면 기다리는 사람 맨앞으로
            if(!deque.isEmpty() && deque.peek() <= startBus) {
                answer = getStringTime(deque.peek() - 1);
                //막차인데도 기다리는 사람이있으면
                if(k == n) {
                    answer = getStringTime(lastCrew - 1);
                }
            }
            if(crewCount == 0) {
                answer = getStringTime(startBus);
            }
            //09:00 -> 08:00
            //09:10 -> 09:09, 09:09
            
            
            crewCount = 0;
            startBus += t;
        }
        
        
        return answer;
    }
    
    private int getTime(String time) {
        String timePart[] = time.split(":");
        return (Integer.parseInt(timePart[0]) * 60) + Integer.parseInt(timePart[1]);
    }
    
    private String getStringTime(int time) {
        int a = time / 60;
        int b = time % 60;
        StringBuffer sb = new StringBuffer();
        String hour = String.valueOf(a);
        if(hour.length() < 2)
            sb.append("0");
        sb.append(hour);
        sb.append(":");
        String minutes = String.valueOf(b);
        if(minutes.length() < 2)
            sb.append("0");
        sb.append(minutes);
        return sb.toString();
    }
}