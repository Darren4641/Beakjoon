import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int age;
        String name;
        int index;
        public Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        int index = 0;
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), index++));
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.age == o2.age) return o1.index - o2.index;
            else return o1.age - o2.age;
        });
        for(Person p : list) bw.write(p.age + " " + p.name + "\n");
        bw.close();
    }
}