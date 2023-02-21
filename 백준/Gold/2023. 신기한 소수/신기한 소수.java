import java.io.*;
import java.util.ArrayList;

public class Main {
    public static final int[] SOSU = {1, 3, 5, 7, 9};

    public static void DFS(int number, int j, int size) throws IOException {
        if(j == size) {
            if(isPrime(number))
                System.out.println(number);
            return;
        }
        for(int i = 0; i < SOSU.length; i++) {
            if(isPrime(number * 10 + SOSU[i]))
                DFS(number * 10 + SOSU[i], j + 1, size);
        }


    }

    public static boolean isPrime(int num) {
        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int size = Integer.parseInt(br.readLine());
            //A = new ArrayList[size];

            DFS(2, 1, size);
            DFS(3, 1, size);
            DFS(5, 1, size);
            DFS(7, 1, size);

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
