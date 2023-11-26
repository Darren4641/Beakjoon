import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N + 1];
        int[] reverseBasket = new int[N + 1];
        //바구니 채우기
        for(int i = 1; i <= N; i++) {
            basket[i] = i;
            reverseBasket[i] = i;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            while(left < right) {
                int temp = basket[left];
                basket[left++] = basket[right];
                basket[right--] = temp;

            }


        }

        for(int i = 1; i <= N; i++) bw.write(basket[i] + " ");
        bw.close();
    }
}
