import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        int index = 0;
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[index][0] = Integer.parseInt(st.nextToken());
            arr[index++][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        for(int[] n : arr) bw.write(n[0] + " " + n[1] + "\n");
        bw.close();
    }
}