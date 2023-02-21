import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static boolean solution(int[] num, int nodeSize) {
        for(int i = 0; i < nodeSize; i++) {
            A[i] = new ArrayList<>();
        }
        //친구관계 형성
        for(int i = 0; i < num.length; i = i + 2) {
            A[num[i]].add(num[i + 1]);
            A[num[i + 1]].add(num[i]);
        }

        for(int i = 0; i < nodeSize; i++) {
            //Arrays.fill(visited, false);

            if(DFS(A[i], i,0)) return true;
        }
        return false;
    }

    public static boolean DFS(ArrayList<Integer> a,int index, int count) {
        if(count == 4) {
            return true;
        }else {
            visited[index] = true;
            for(int i = 0; i < a.size(); i++) {
                if(!visited[a.get(i)]) {
                    visited[a.get(i)] = true;
                    if(DFS(A[a.get(i)], a.get(i), count + 1)) return true;
                }
            }
            visited[index] = false;

        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            A  = new ArrayList[nodeSize];
            visited = new boolean[nodeSize];
            int[] num = new int[edgeSize * 2];

            for(int i = 0; i < num.length; i = i + 2) {
                st = new StringTokenizer(br.readLine(), " ");
                num[i] = Integer.parseInt(st.nextToken());
                num[i + 1] = Integer.parseInt(st.nextToken());
            }

            if(solution(num, nodeSize))  System.out.println("1");
            else System.out.println(0);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
