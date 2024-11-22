package paiza.rankB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B131 {

    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static int x;
    static int curDir = 1;
    static int[][] price;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        price = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (s > curDir)
                answer += price[r - 1][s - 1] - price[r - 1][curDir - 1];
            else if (s < curDir)
                answer += price[r - 1][curDir - 1] - price[r - 1][s - 1];
            curDir = s;
        }

        System.out.println(answer);
        br.close();
    }
}
