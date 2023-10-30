class Solution {
    public int solution(String[] board) {
        int X_count = 0;
        int O_count = 0;
        int answer = -1;
        // O . X
        // . O .
        // . . X
        for(int i = 0; i < board.length; i++) {
            String current = board[i];
            for(int j = 0; j < 3; j++) {
                if(current.charAt(j) == 'X') X_count += 1;
                else if(current.charAt(j) == 'O') O_count += 1;    
            }
            
        }
        
        if(X_count > O_count || O_count - X_count > 1) return 0;
        boolean X_win = false;
        boolean O_win = false;
        X_win = isValid(board, 'X');
        O_win = isValid(board, 'O');
        if(X_win && O_win) return 0;
        if(O_win && (O_count - X_count) != 1) return 0;
        if(X_win && (X_count != O_count)) return 0;
    
        
        return 1;
    }
    
    private boolean isValid(String[] board, char mark) {
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(0) == mark && board[i].charAt(1) == mark && board[i].charAt(2) == mark) return true;
            if(board[0].charAt(i) == mark && board[1].charAt(i) == mark && board[2].charAt(i) == mark) return true;
            
            
        }
        if(board[0].charAt(0) == mark && board[1].charAt(1) == mark && board[2].charAt(2) == mark) return true;
        if(board[0].charAt(2) == mark && board[1].charAt(1) == mark && board[2].charAt(0) == mark) return true;
        return false;
    }
}