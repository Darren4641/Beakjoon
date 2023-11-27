import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        String word = br.readLine();
        int sum = 0;
        for(String c : croatia) {
            if(word.contains(c)) {
                word = word.replaceAll(c, "a");
            }
        }

        bw.write(word.length() + "");
        bw.close();
    }
}
