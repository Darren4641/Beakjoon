import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static class Product {
        int price;
        int count;

        public Product(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<Product> list = new ArrayList<>();

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            list.add(new Product(price, count));
        }
        AtomicLong result = new AtomicLong();
        list.stream().forEach(p -> result.addAndGet((long) p.price * p.count));
        bw.write(X == result.get() ? "Yes" : "No");
        bw.close();
    }
}
