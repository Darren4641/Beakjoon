class Solution {
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //초기 손 위치
        int left = 10;
        int right = 12;
        StringBuilder sb = new StringBuilder();

        for(int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {
                left = number;
                sb.append("L");
            } else if(number == 3 || number == 6 || number == 9) {
                right = number;
                sb.append("R");
            } else {
                if(number == 0) {
                    number = 11;
                }
                
                int leftDiff = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
                int rightDiff = (Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);
                if(leftDiff == rightDiff) {
                    if(hand.equals("right")) {
                        right = number;
                        sb.append("R");
                    } else {
                        left = number;
                        sb.append("L");
                    }
                } else if(leftDiff < rightDiff) {
                    left = number;
                    sb.append("L");
                } else if(leftDiff > rightDiff) {
                    right = number;
                    sb.append("R");
                }
                    
            }
        }
        
        return sb.toString();
    }
    
    
}