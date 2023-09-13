
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int INF = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] city = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                city[i][j] = INF;
                if(i == j) city[i][j] = 0;
            }
        }


        for(int i = 0; i < M; i++) {
            //버스 시작 도시 , 도착 도시, 한번 타는 비용
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            city[start][end] = Math.min(city[start][end], money);
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if((city[i][k] != INF && city[k][j] != INF) && city[i][j] > city[i][k] + city[k][j])
                        city[i][j] = city[i][k] + city[k][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(city[i][j] == INF)
                    city[i][j] = 0;
                sb.append(city[i][j] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();

    }

    
}
