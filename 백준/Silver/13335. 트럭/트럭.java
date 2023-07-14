import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static Deque<Integer> trucks;
    public static Deque<Integer> complete;
    public static Deque<Integer> bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //트럭 수
        int w = Integer.parseInt(st.nextToken()); //다리 길이
        int L = Integer.parseInt(st.nextToken()); //다리의 최대 하중

        trucks = new ArrayDeque<Integer>();
        complete = new ArrayDeque<Integer>();
        bridge = new ArrayDeque<Integer>();

        int size = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trucks.addLast(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < w; i++) bridge.addLast(0);

        int time = 0;
        int weight = 0;
        while(complete.size() != n) {
            if(bridge.getFirst() != 0) {
                complete.addLast(bridge.getFirst());
            }
            weight -= bridge.getFirst();
            bridge.removeFirst();

            if(trucks.size() > 0) {
                if(weight + trucks.getFirst() <= L) {
                    int temp = trucks.pop();
                    weight += temp;
                    bridge.addLast(temp);
                }else bridge.addLast(0);
            }

            time++;
        }
        bw.write(time + "");
        bw.close();


    }
}
