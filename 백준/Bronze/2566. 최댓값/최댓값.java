import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int value;
        int row;
        int col;
        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Node> list = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                list.add(new Node(value, i, j));
            }
        }
        Collections.sort(list, (s1, s2) -> s2.value - s1.value);
        bw.write(list.get(0).value + "\n");
        bw.write(list.get(0).row + " " + list.get(0).col);


        bw.close();
    }
}
