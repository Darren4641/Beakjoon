import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        int index2 = 0;
        int[] arr = new int[N];
        int[] arr2 = new int[N];
        while(N-- > 0) {
            arr[index++] = Integer.parseInt(st.nextToken());
            arr2[index2++] = arr[index - 1];
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int a : arr) {
            if(map.get(a) == null) {
                map.put(a, i++);
            }
        }
        for(int a : arr2) {
            bw.write(map.get(a) + " ");
        }

        bw.close();
    }
}