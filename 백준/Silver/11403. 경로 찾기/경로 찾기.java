import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    //단순히 갈 수 있는 경로가 있는지 체크
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                sb.append(graph[i][j] + " ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
