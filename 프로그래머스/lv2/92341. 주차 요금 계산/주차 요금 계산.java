import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> in = new HashMap<String, String>();
        Map<String, Integer> result = new HashMap<String, Integer>();
        int[] answer;
        
        int defaultTime = fees[0];
        int defaultMoney = fees[1];
        int perMinute = fees[2];
        int perMoney = fees[3];
        
        
        for(int i = 0; i < records.length; i++) {
            String car[] = records[i].split(" ");
            String time = car[0];
            String carNum = car[1];
            String type = car[2];
            
            if(type.equals("IN")) {
                in.put(carNum, time);
                
            }else if(type.equals("OUT")) {
                if(in.containsKey(carNum)) {
                    int cc = getMinute(time) - getMinute(in.get(carNum));
                    in.remove(carNum);
                    result.put(carNum, result.getOrDefault(carNum, 0) + cc);
                }
                
            }
            
        }
        
        for(Map.Entry<String, String> entry : in.entrySet()) {
            int cc = getMinute("23:59") - getMinute(entry.getValue());
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + cc);
        }
        
        answer = new int[result.size()];
        int i = 0;
        List<String> list = new ArrayList<String>(result.keySet());
        list.sort((s1, s2) -> s1.compareTo(s2));
        for(String key : list) {
            System.out.println(result.get(key));
            answer[i] = calculate(defaultMoney, result.get(key), defaultTime, perMinute, perMoney);
            i++;
        }
        
        return answer;
    }
    
    private int getMinute(String time) {
        String m[] = time.split(":");
        return (Integer.parseInt(m[0]) * 60) + Integer.parseInt(m[1]);
    }
    
    private int calculate(int defaultMoney, int cc, int defaultTime, int perMinute, int perMoney){
        int a = cc - defaultTime;
        if(a < 0) return defaultMoney;
        int b = (int) Math.ceil(a / (double) perMinute);
        return (defaultMoney + (b * perMoney));
    }
}