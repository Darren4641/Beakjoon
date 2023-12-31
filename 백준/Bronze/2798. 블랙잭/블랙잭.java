import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while(N-- > 0) {
            cards[index++] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i = 0; i < cards.length - 2; i++) {
            for(int j = i + 1; j < cards.length - 1; j++) {
                for(int k = j + 1; k < cards.length; k++) {
                    int temp = cards[i] + cards[j] + cards[k];
                    if(temp <= M) {
                        answer = Math.max(answer, temp);
                    }
                }
            }
        }
        bw.write(answer + "");
        bw.close();
    }
}