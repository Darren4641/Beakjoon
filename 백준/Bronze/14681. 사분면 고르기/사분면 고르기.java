import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());

        if(X > 0 && Y > 0) bw.write("1");
        else if(X > 0 && Y < 0) bw.write("4");
        else if(X < 0 && Y > 0) bw.write("2");
        else if(X < 0 && Y < 0) bw.write("3");

        bw.close();
    }
}
