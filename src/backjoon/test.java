package backjoon;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        int value = tt(map);
        System.out.println(value);
        System.out.println(map.get("1"));
    }

    public static int tt(Map<String, String> map) {
        map.put("1", "1");
        return 1;
    }
}
