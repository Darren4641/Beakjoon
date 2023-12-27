import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      
        int X = Integer.parseInt(br.readLine());
        int line = 1;
        int r = 0, c = 0;
        int count = 0;
        boolean flag = false;
        boolean zigzag = false;
        while(true) {
            for(int row = 1; row <= line; row++) {
                if(zigzag) {
                    r = row;
                    c = line - (row - 1);
                }else {
                    r = line - (row - 1);
                    c = row;
                }
                count++;
                if(count == X) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            line++;
            zigzag = !zigzag;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(r);
        sb.append("/");
        sb.append(c);
        bw.write(sb.toString());
        bw.close();
    }
}
