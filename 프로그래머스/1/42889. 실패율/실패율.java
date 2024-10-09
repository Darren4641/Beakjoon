import java.util.*;

class Solution {
    
    static class Stage {
        int level;
        double failureRate;
        
        public Stage(int level, double failureRate) {
            this.level = level;
            this.failureRate = failureRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        
        Map<Integer, Integer> stageUserMap = calUserCountGroupByStage(N, stages);
        
        List<Stage> stageList = new ArrayList<>();
        int totalCount = stages.length;
        for(int stage = 1; stage <= N; stage++) {
            int stageCount = stageUserMap.get(stage);
            
            double failure = 0.0;
            if(totalCount > 0) {
                failure = ((double) stageCount / totalCount);       
            }
            
            stageList.add(new Stage(stage, failure));
            
            totalCount -= stageCount;
        }
        
        Collections.sort(stageList, ( o1, o2 ) -> {
            if(o1.failureRate == o2.failureRate) return o1.level - o2.level;
            else return Double.compare(o2.failureRate, o1.failureRate);
        });

        for(int i = 0; i < stageList.size(); i++) {
            answer[i] = stageList.get(i).level;
        }
        
        
        return answer;
    }
    
    private Map<Integer, Integer> calUserCountGroupByStage(int N, int[] stages) {
        // 유저별 멈춘 스테이지 갯수 구하기
        Map<Integer, Integer> stageUserMap = new HashMap<>();
        
        for(int i = 1; i <= N; i++) stageUserMap.put(i, 0);
        
        for(int stage : stages) {
            if(stageUserMap.containsKey(stage)) {
                stageUserMap.put(stage, stageUserMap.get(stage) + 1);
            }   
        }


        return stageUserMap;
    }
    
    
}