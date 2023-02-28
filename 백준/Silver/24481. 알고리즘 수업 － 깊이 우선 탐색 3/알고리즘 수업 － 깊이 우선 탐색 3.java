import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] node;
    static boolean[] visited;
    static int[] result;

    public static void solution(int startEdge) {
        visited = new boolean[node.length];
        result = new int[node.length];

        DFS(startEdge, 0);

        for(int i = 1; i < visited.length; i++) {
            if(!visited[i])
                System.out.println(-1);
            else
                System.out.println(result[i]);
        }
    }

    public static void DFS(int v, int index) {
        visited[v] = true;
        result[v] = index;

        for(int n : node[v]) {
            if(!visited[n]) {
                DFS(n, index+1);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            node = new LinkedList[Integer.parseInt(st.nextToken()) + 1];

            for(int i = 1; i < node.length; i++) {
                node[i] = new LinkedList<Integer>();
            }

            int edgeCount = Integer.parseInt(st.nextToken());
            int startEdge = Integer.parseInt(st.nextToken());
            int n1, n2;
            for(int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                n1 = Integer.parseInt(st.nextToken());
                n2 = Integer.parseInt(st.nextToken());
                node[n1].add(n2);
                node[n2].add(n1);
            }

            for(int i = 1; i < node.length; i++) {
                Collections.sort(node[i]);
            }

            solution(startEdge);

        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}
