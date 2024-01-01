import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while(N-- > 0) {
            set.add(br.readLine());
        }
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });
        for(String s : arr) bw.write(s + "\n");
        bw.close();
    }
}