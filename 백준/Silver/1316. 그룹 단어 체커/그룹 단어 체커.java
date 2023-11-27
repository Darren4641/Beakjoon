import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(T-- > 0) {
            String word = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            boolean isGroupWord = true;

            char c = word.charAt(0); // h a p
            map.put(c, 1);

            for(int j = 1; j < word.length(); j++) {

                if(map.get(word.charAt(j)) == null) {
                    map.put(word.charAt(j), 1);
                }else {
                    //이전 값이랑 같은 경우
                    if(c == word.charAt(j)) continue;
                    else {
                        isGroupWord = false;
                        break;
                    }
                }

                c = word.charAt(j);

            }
            if(isGroupWord) {
                cnt++;
            }


        }
        bw.write(cnt + "");
        bw.close();
    }
}
