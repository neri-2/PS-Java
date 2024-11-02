package baekjoon.silver.iv.n10994;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] star = new char[4 * (N - 1) + 1][4 * (N - 1) + 1];

        for (int i = 0; i < 4 * (N - 1) + 1; i++) {
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                star[i][j] = ' ';
            }
        }

        recursion(0, star, N);

        for (char[] chars : star) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
        br.close();
    }

    private static void recursion(int start, char[][] star, int n) {
        if (n < 1) return;
        int cnt = start + 4 * (n - 1);
        for (int i = start; i <= cnt; i++) {
            star[start][i] = '*';
            star[i][start] = '*';
            star[cnt][i] = '*';
            star[i][cnt] = '*';
        }
        recursion(start + 2, star, n - 1);
    }
}
