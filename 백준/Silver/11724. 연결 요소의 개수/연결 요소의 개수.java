import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static int solution() {
        int count = 0;

        for(int i = 1; i <A.length; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        return count;
    }

    public static void DFS(int v) {
        if(visited[v]) return;

        visited[v] = true;

        for(int i : A[v]) {
            if(!visited[i])
                DFS(i);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int u,v;

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            visited = new boolean[size + 1];
            A = new ArrayList[size + 1];
            //인접리스트 생성
            for(int i = 1; i <= size; i++) {
                A[i] = new ArrayList<Integer>();
            }

            //인접리스트 연결
            for(int i = 0; i < edgeSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                A[u].add(v);
                A[v].add(u);
            }

            bw.write(solution() + "");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
