import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = new int[5];
        int avg = 0;
        for(int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            avg += nums[i];
        }
        avg /= 5;
        Arrays.sort(nums);
        bw.write(avg + "\n");
        bw.write(nums[2] + "\n");
        bw.close();
    }
}