import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static LinkedList<Integer>[] node;
    public static int[] num;

    public static void solution(int startEdge) {
        visited = new boolean[node.length];
        num = new int[node.length];
        DFS(startEdge);

        for(int i = 1; i < num.length; i++) {
            System.out.println(num[i]);
        }

    }

    public static void DFS(int v) {
        int cnt = 1;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        visited[v] = true;
        deque.addLast(v);

        int now;
        while(!deque.isEmpty()) {
            now = deque.removeFirst();
            num[now] = cnt;
            for(int n : node[now]) {
                if(!visited[n]) {
                    visited[n] = true;
                    deque.addLast(n);
                }
            }
            cnt++;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = new LinkedList[Integer.parseInt(st.nextToken()) + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new LinkedList<Integer>();
        }

        int edgeCount = Integer.parseInt(st.nextToken());
        int startEdge = Integer.parseInt(st.nextToken());
        int n1, n2;
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            node[n1].add(n2);
            node[n2].add(n1);
        }

        for (int i = 1; i < node.length; i++) {
            Collections.sort(node[i], Collections.reverseOrder());
        }

        solution(startEdge);

    }

}
