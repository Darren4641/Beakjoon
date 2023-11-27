import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        word = word.toUpperCase();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i));
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //갯수 기준으로 정렬
        List<Map.Entry<String, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(list, (s1, s2) -> s2.getValue() - s1.getValue());
        if(list.size() > 1 && Objects.equals(list.get(0).getValue(), list.get(1).getValue())) bw.write("?");
        else bw.write(list.get(0).getKey() + "");
        bw.close();
    }
}
