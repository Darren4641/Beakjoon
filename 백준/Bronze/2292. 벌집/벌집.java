import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;

        int result = 1;
        while(true) {

            if(start <= N && N <= end) {
                bw.write(result + "");
                break;
            }
            start = end + 1;
            end += (result * 6);
            result++;
        }


        bw.close();
    }
}
