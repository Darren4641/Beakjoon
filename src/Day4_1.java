import java.util.Arrays;

public class Day4_1 {
    public static final String START = "S";
    public static final String WALK = "O";
    public static final String NON_WALK = "X";

    public static String[][] way;
    public int[] solution(String[] park, String[] routes) {
        int row_max = park.length;
        int col_max = park[0].length();
        way = new String[row_max][col_max];

        int row = 0, col = 0;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                way[i][j] = String.valueOf(park[i].charAt(j));
                if(way[i][j].equals(START)) {
                    row = i;
                    col = j;
                }

            }
        }
        String[] temp;
        boolean flag;
        for(int k = 0; k < routes.length; k++) {
            flag = true;
            temp = routes[k].split(" ");

            if(temp[0].equals("N")) {
                for(int i = 1; i <= Integer.parseInt(temp[1]); i++) {
                    if(isNonWalk(row - i, col, row_max, col_max)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) row -= Integer.parseInt(temp[1]);
            }else if(temp[0].equals("S")) {
                for(int i = 1; i <= Integer.parseInt(temp[1]); i++) {
                    if(isNonWalk(row + i, col, row_max, col_max)) {
                        flag = false;
                        break;

                    }
                }
                if(flag) row += Integer.parseInt(temp[1]);
            }else if(temp[0].equals("W")) {
                for(int i = 1; i <= Integer.parseInt(temp[1]); i++) {
                    if(isNonWalk(row, col - i, row_max, col_max)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) col -= Integer.parseInt(temp[1]);
            }else if(temp[0].equals("E")) {
                for(int i = 1; i <= Integer.parseInt(temp[1]); i++) {
                    if(isNonWalk(row, col + i, row_max, col_max)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) col += Integer.parseInt(temp[1]);
            }

        }

        int[] answer = {row, col};
        return answer;
    }

    public boolean isWay(int row, int col, int row_max, int col_max) {
        return (row >= 0 && row < row_max) && (col >= 0 && col < col_max);
    }

    public boolean isNonWalk(int row, int col, int row_max, int col_max) {
        if(!isWay(row, col, row_max, col_max) || way[row][col].equals("X")) {
            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        String[] park = {"SOO","OOO", "OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        System.out.println(new Day4_1().solution(park, routes)[0] + " " + new Day4_1().solution(park, routes)[0]);
    }
}
