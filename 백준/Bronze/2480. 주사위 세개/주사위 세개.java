import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[3];
        int[] arr = new int[7];

        for(int i = 0; i < 3; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            arr[dice[i]] += 1;
        }

        int same = arr[1];
        int num = 1;
        for(int i = 2; i < 7; i++) {
            if(arr[i] > same) {
                same = arr[i];
                num = i;
            }

        }
        int answer = 0;
        if(same == 3) {
            answer = 10000 + (num * 1000);
        }else if(same == 2) {
            answer = 1000 + (num * 100);
        }else {
            answer = Math.max(dice[0], Math.max(dice[1], dice[2])) * 100;
        }

        bw.write(answer + "");
        bw.close();
    }
}
