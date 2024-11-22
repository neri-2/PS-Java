package paiza.rankA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A051 {

    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] ita;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ita = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ita[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(calculate());
    }

    private static int calculate() {
        final int[] nums = {-1, 0, 1};
        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max = 0;
                for (int num : nums) {
                    if (j + num < 0 || j + num >= m) continue;
                    if (max < ita[i - 1][j + num]) max = ita[i - 1][j + num];
                }
                ita[i][j] += max;
            }
        }
        for (int i : ita[n - 1]) {
            if (i > result) result = i;
        }
        return result;
    }
}
