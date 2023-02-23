import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void solution(int[]media, int lessonCnt, int blueLayCnt) {

        int start = 0;
        int end = 0;
        for(int i = 0; i < lessonCnt; i++) {
            start = Math.max(start, media[i]);
            end += media[i];
        }

        int mid;
        while(start <= end) {
            int sum = 0;
            int cnt = 0;
            mid = (start + end) / 2;
            for(int i = 0; i < lessonCnt; i++) {
                if(sum + media[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += media[i];
            }
            if(sum != 0) cnt++;

            if(cnt > blueLayCnt) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }

        }
        System.out.println(start);



    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int lessonCnt = Integer.parseInt(st.nextToken());
            int blueLayCnt = Integer.parseInt(st.nextToken());
            int[] media = new int[lessonCnt];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < lessonCnt; i++) {
                media[i] = Integer.parseInt(st.nextToken());
            }
            solution(media, lessonCnt, blueLayCnt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
