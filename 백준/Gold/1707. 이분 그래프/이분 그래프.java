
import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            visited = new int[V + 1];
            for(int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            for(int n = 0; n < E; n++) {
                st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                graph[s1].add(s2);
                graph[s2].add(s1);
            }
            bw.write(bfs(V) ? "YES\n" : "NO\n");
        }
        bw.close();
    }

    public static boolean bfs(int V) {
        Queue<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= V; i++) {
            if(visited[i] == 0) {
                deque.add(i);
                visited[i] = 1;
            }

            while(!deque.isEmpty()) {
                int curNode = deque.poll();

                for(int j = 0; j < graph[curNode].size(); j++) {
                    int curIndex = graph[curNode].get(j);
                    if(visited[curIndex] == 0) deque.add(curIndex);
                    if(visited[curIndex] == visited[curNode]) return false;

                    if(visited[curIndex] == 0 && visited[curNode] == 1)
                        visited[curIndex] = 2;
                    else if(visited[curIndex] == 0 && visited[curNode] == 2)
                        visited[curIndex] = 1;
                }
            }

        }
        return true;
    }

}
