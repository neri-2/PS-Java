package baekjoon.silver.iv.n25214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static List<Integer> dp = new ArrayList<>();
    static int min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        min = Integer.parseInt(st.nextToken());
        dp.add(0);

        for (int i = 1; i < N; i++) {
            int curNum = Integer.parseInt(st.nextToken());

            if (dp.get(i - 1) < curNum - min) {
                dp.add(curNum - min);
            } else dp.add(dp.get(i - 1));

            if (curNum < min) min = curNum;
        }

        for (Integer integer : dp) {
            System.out.print(integer + " ");
        }
        System.out.println();

        br.close();
    }
}
