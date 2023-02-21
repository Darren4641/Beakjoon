import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] A;
    static boolean[] visited;
    public static int solution(int[] num, int size) {
        int answer = 0;
        init(num, size);

        for(int i = 1; i <= size; i++) {
            if(!visited[i])
                answer += DFS(A[i]);
        }

        return answer;
    }

    public static int DFS(List<Integer> a) {
        for(int value : a) {
            if(!visited[value]) {
                visited[value] = true;
                DFS(A[value]);
            }
        }
        return 1;
    }

    public static void init(int[] num, int size) {
        A = new ArrayList[size + 1];
        visited = new boolean[size + 1];
        for(int i = 1; i <= size; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i < num.length; i = i + 2) {
            A[num[i]].add(num[i + 1]);
            A[num[i + 1]].add(num[i]);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());


            int[] num = new int[edge * 2];

            for(int i = 0; i < num.length; i = i + 2) {
                st = new StringTokenizer(br.readLine(), " ");
                num[i] = Integer.parseInt(st.nextToken());
                num[i + 1] = Integer.parseInt(st.nextToken());
            }

            bw.write(String.valueOf(solution(num, size)));
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
