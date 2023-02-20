import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String num = br.readLine();
            Integer[] array = new Integer[num.length()];
            for(int i = 0; i < num.length(); i++) {
                array[i] = num.charAt(i) - '0';
            }

            Arrays.sort(array, Collections.reverseOrder());

            for(int i = 0; i < array.length; i++) {
                bw.write(array[i] + "");
            }
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
