import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static boolean[] visited;
    public static int[] out;
    public static void solve(int depth, int N) {
        if(depth == N) {
            for(int o : out) System.out.print(o + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                solve(depth + 1, N);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        out = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        visited = new boolean[N];
        solve(0, N);

        bw.close();
    }
}
