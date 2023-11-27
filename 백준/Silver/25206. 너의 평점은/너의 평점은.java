import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    static class Node {
        String subject;
        double point;
        String rank;

        public Node(String subject, double point, String rank) {
            this.subject = subject;
            this.point = point;
            this.rank = rank;
        }

        public Double culPoint() {
            if(rank.equals("A+")) return 4.5 * point;
            else if(rank.equals("A0")) return 4.0 * point;
            else if(rank.equals("B+")) return 3.5 * point;
            else if(rank.equals("B0")) return 3.0 * point;
            else if(rank.equals("C+")) return 2.5 * point;
            else if(rank.equals("C0")) return 2.0 * point;
            else if(rank.equals("D+")) return 1.5 * point;
            else if(rank.equals("D0")) return point;
            return 0.0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //학점 * 과목 평점
        String temp;
        List<Node> list = new ArrayList<>();
        double size = 0;
        while( (temp = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(temp);
            String subject = st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String rank = st.nextToken();
            if(!rank.equals("P")) size += point;
            list.add(new Node(subject, point, rank));
        }
        AtomicReference<Double> sum = new AtomicReference<>(0.0);

        list.stream().filter(node -> !node.rank.equals("P"))
                .forEach(node -> sum.updateAndGet(v -> v + node.culPoint()));
        double answer = Math.round((sum.get() / size) * 1000000) / 1000000.0;
        bw.write(answer + "");
        bw.close();
    }
}
