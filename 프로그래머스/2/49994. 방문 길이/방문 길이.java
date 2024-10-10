import java.util.*;

class Solution {
    public static final int MAX = 5;
    
    static class Character {
        int x;
        int y;
        boolean isWay;
        
        public Character() {
            this.x = 0;
            this.y = 0;
        }
        
        public void up() {
            this.y += 1;
            checkWay();
            if(!isWay) this.y -=1;
        }
        
        public void down() {
            this.y -= 1;
            checkWay();
            if(!isWay) this.y +=1;
        }
        
        public void left() {
            this.x -= 1;
            checkWay();
            if(!isWay) this.x +=1;
        }
        
        public void right() {
            this.x += 1;
            checkWay();
            if(!isWay) this.x -=1;
        }
        
        private void checkWay() {
            if(Math.abs(x) > 5 || Math.abs(y) > 5) this.isWay = false;
            else this.isWay = true;
        }
    }
    
    public int solution(String dirs) {
        int answer = 0; 
        
        Character character = new Character();
        Set<String> moveSet = new HashSet<>();
        
        int conflict = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char currentCommand = dirs.charAt(i);
            
            String beforePath = String.valueOf(character.x) + String.valueOf(character.y);
            switch(currentCommand) {
                case 'U' : 
                    character.up();
                    break;
                case 'D' : 
                    character.down();
                    break;
                case 'L' : 
                    character.left();
                    break;
                case 'R' : 
                    character.right();
                    break;
            }
            String afterPath = String.valueOf(character.x) + String.valueOf(character.y);
            if(character.isWay)
                moveSet.add(
                (beforePath + afterPath).compareTo((afterPath + beforePath)) < 0 ? 
                (beforePath + afterPath) : (afterPath + beforePath));
            
        }
    
        return moveSet.size();
        
    }
    
}