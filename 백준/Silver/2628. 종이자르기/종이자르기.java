import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] paper = new int[x][y];

        int cut = Integer.parseInt(br.readLine());
        List<Integer> rowCutList = new ArrayList<>();
        List<Integer> colCutList = new ArrayList<>();
        rowCutList.add(0);
        rowCutList.add(y);
        colCutList.add(0);
        colCutList.add(x);

        for (int i = 0; i < cut; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            if (type == 0) {
                //row cut
                rowCutList.add(point);
            } else {
                //col cut
                colCutList.add(point);
            }

        }
        Collections.sort(rowCutList);
        Collections.sort(colCutList);
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < rowCutList.size() - 1; i++) {
            maxY = Math.max(rowCutList.get(i + 1) - rowCutList.get(i), maxY);
        }
        for(int i = 0; i < colCutList.size() - 1; i++) {
            maxX = Math.max(colCutList.get(i + 1) - colCutList.get(i), maxX);
        }

        bw.write(maxX * maxY + "");
        bw.close();
    }


}