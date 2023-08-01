
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static final String SANSUNG = "SANSUNG";
    public static final String ALCALY = "ALCALY";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] array = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Long> deque = new ArrayDeque<Long>();
        for(int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
            deque.addLast(array[i]);
        }
        long answer[] = new long[2];
        long max = Long.MAX_VALUE;
        // i = 0
        // N = 5
        for(int i = 0; i < N; i++) {
            int start = i + 1; //start = 1
            int end = N - 1;  // end = 4
            while(start <= end) {
                int mid = (start + end) / 2; //mid = 2

                long sum = array[i] + array[mid]; //sum = -99 + -1 = -100

                if(Math.abs(sum) < max) {
                    answer[0] = array[i];
                    answer[1] = array[mid];
                    max = Math.abs(sum);
                }

                if(sum < 0) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }

            }
        }

        System.out.println(answer[0] + " " + answer[1]);



//        int i = 0;
//        while(start <= end) {
//            long mid = (start + end) / 2;
//
//            long target = array[i];
//
//            while(!deque.isEmpty()) {
//                long now = deque.removeFirst();
//
//
//            }
//
//        }

    }
}
