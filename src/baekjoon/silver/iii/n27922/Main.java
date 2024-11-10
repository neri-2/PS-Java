package baekjoon.silver.iii.n27922;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] ans1;
    static int[] ans2;
    static int[] ans3;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ans1 = new int[N];
        ans2 = new int[N];
        ans3 = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] lecs = new int[3];
            for (int j = 0; j < 3; j++) lecs[j] = Integer.parseInt(st.nextToken());
            ans1[i] = lecs[0] + lecs[1];
            ans2[i] = lecs[1] + lecs[2];
            ans3[i] = lecs[0] + lecs[2];
        }

        Arrays.sort(ans1);
        Arrays.sort(ans2);
        Arrays.sort(ans3);

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0; i < K; i++) {
            sum1 += ans1[(N - 1) - i];
            sum2 += ans2[(N - 1) - i];
            sum3 += ans3[(N - 1) - i];
        }

        System.out.println(Math.max(Math.max(sum1, sum2), sum3));
        br.close();
    }
}
