import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        //word.indexOf()
        int alphabet = 96;
        while(alphabet++ < 122) {
            int index = word.indexOf((char) alphabet);
            bw.write(index + " ");
        }

        bw.close();
    }
}
