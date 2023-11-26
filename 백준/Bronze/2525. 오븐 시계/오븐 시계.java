import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());

        int temp = (hour * 60) + minutes;

        int time = Integer.parseInt(br.readLine());
        temp += time;
        int answerHour = (temp / 60) >= 24 ?  (temp / 60) - 24: (temp / 60);
        bw.write(answerHour + " " + (temp % 60));
        //100분
        //100/60 = 1
        bw.close();
    }
}
