import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = INF;

                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A][B] = graph[B][A] = 1;
        }


        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int compare = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1; i < graph.length; i++) {
            int sum = 0;
            for(int j = 1; j < graph[0].length; j++) {
                sum += graph[i][j];
            }
            if(compare > sum) {
                compare = sum;
                answer = i;
            }
        }
        bw.write(answer + "");
        bw.close();
    }

    public static void print(int[][] graph) {

    }

    /*
      1 2 3 4 5
    1 0 0 1 1 0
    2 0 0 0 0 0
    3 0 1 0 0 0
    4 0 0 0 0 1
    5 0 0 0 0 0
     */
}
