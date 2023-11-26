import java.io.*;
import java.util.StringTokenizer;


public class Main {


    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node[] node = new Node[9];
        for(int i = 0; i < 9; i++) {
            node[i] = new Node(i + 1, Integer.parseInt(br.readLine()));
        }

        Node max = node[0];
        for(Node n : node) {
            if(max.value < n.value) max = n;
        }
        bw.write(max.value + "\n");
        bw.write(max.index + "");


        bw.close();
    }
}
