import java.util.*;

class Solution {
    
    static class Subject {
        String name;
        int startTime; // 시작 시간 (분 단위)
        int remainingTime; // 남은 공부 시간
        
        public Subject(String name, String time, int remainingTime) {
            this.name = name;
            this.startTime = (Integer.parseInt(time.split(":")[0]) * 60) + Integer.parseInt(time.split(":")[1]);
            this.remainingTime = remainingTime;
        }
    }
    
    
    public List<String> solution(String[][] plans) {
         
        List<Subject> subjectList = new ArrayList<>();
        
        for (String[] plan : plans) {
            subjectList.add(new Subject(plan[0], plan[1], Integer.parseInt(plan[2])));
        }
        
        // 시작 시간 기준으로 정렬
        Collections.sort(subjectList, Comparator.comparingInt(o -> o.startTime));
        
        Stack<Subject> waitStack = new Stack<>();
        List<String> result = new ArrayList<>();
        
        
        for(int i = 0; i < subjectList.size() - 1; i++) {
            Subject currentSubject = subjectList.get(i);
            Subject nextSubject = subjectList.get(i + 1);
            //System.out.println("curent = " + currentSubject.name);
            //System.out.println("next = " + nextSubject.name);
             
            int currentEndTime = currentSubject.startTime + currentSubject.remainingTime;
            if(currentEndTime > nextSubject.startTime) {
                currentSubject.remainingTime -= (nextSubject.startTime - currentSubject.startTime);
                //System.out.println("다 못끝냄  (" + currentSubject.name + ") " + currentSubject.remainingTime);
                waitStack.push(currentSubject);
            } else {
                //현재 과제 완료
                result.add(currentSubject.name);
                int restTime = nextSubject.startTime - currentEndTime;
                //System.out.println("쉬는 시간 : " + restTime);
                while(!waitStack.isEmpty() && restTime > 0) {
                    Subject prevSubject = waitStack.pop();
                    if (prevSubject.remainingTime <= restTime) {
                        restTime -= prevSubject.remainingTime;
                        result.add(prevSubject.name);
                        //System.out.println(restTime + " 동안 " + completeSubject.name + " 다 끝냄");
                    } else {
                        prevSubject.remainingTime -= restTime;
                        waitStack.push(prevSubject);
                        //System.out.println(restTime + " 동안 " + noneCompleteSubject.name + " " + noneCompleteSubject.remainingTime + " 끝냄");
                        break;
                    }
                    
                }
                
                
            }
            if(i == subjectList.size() - 2) {
                    result.add(nextSubject.name);
            }
        }
        
        while(!waitStack.isEmpty()) {
            Subject lastSubject = waitStack.pop();
            result.add(lastSubject.name);
        }
        
        return result;
    }
}