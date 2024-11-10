package baekjoon.bronze.ii.n14491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 0;
        int nine = 9;
        while (nine <= T) {
            nine *= 9;
            count++;
        }
        for (int i = count; i > 0; i--) {
            int div = 1;
            for (int j = 0; j < i; j++) {
                div *= 9;
            }
            System.out.print(T / div);
            T %= div;
        }
        System.out.print(T % 9);
        System.out.println();

        br.close();
    }
}
