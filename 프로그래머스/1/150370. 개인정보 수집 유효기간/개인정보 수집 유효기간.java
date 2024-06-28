import java.util.*;

class Solution {
    public static final int YEAR = 0;
    public static final int MONTH = 1;
    public static final int DAY = 2;
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] todayDate = today.split("\\.");
        
        
        Map<String, Integer> termsMap = getTerms(terms);
        int index = 1;
        for(String privacie : privacies) {
            String[] date = privacie.split("\\.");
            String p = privacie.split(" ")[1];
            
            int year = 0;
            int month = 0;
            int day = Integer.parseInt(date[DAY].split(" ")[0]) - 1;
            if(day == 0) {
                month -= 1;
                day = 28;
            }
            month += Integer.parseInt(date[MONTH]) + (termsMap.get(p) % 12);
            if(month > 12) {
                year += month / 12;
                month = month % 12;
            }
            year += Integer.parseInt(date[YEAR]) + (termsMap.get(p) / 12);
            //System.out.println(year+"."+month+"."+day);
            if(Integer.parseInt(todayDate[YEAR]) > year) {
                answer.add(index);
            } else if(Integer.parseInt(todayDate[YEAR]) == year && Integer.parseInt(todayDate[MONTH]) > month) {
                answer.add(index);
            } else if(Integer.parseInt(todayDate[YEAR]) == year && Integer.parseInt(todayDate[MONTH]) == month && Integer.parseInt(todayDate[DAY]) > day) {
                answer.add(index);
            }
            index++;
        }
        
        return answer;
    }
    
    private Map<String, Integer> getTerms(String[] terms) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        return map;
    }
}