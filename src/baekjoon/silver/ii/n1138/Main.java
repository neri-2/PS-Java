package baekjoon.silver.ii.n1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];

        st = new StringTokenizer(br.readLine());
        // 1부터 N까지 위치 파악
        for (int i = 0; i < N; i++) {
            // cur = 왼쪽에 자기보다 키가 큰 사람 몇 명인지
            int cur = Integer.parseInt(st.nextToken());
            // count = 빈 자리 세기 (이미 있는 자리는 자기보다 키 작음)
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (ans[j] == 0) count++;
                if (count > cur) {
                    // 본인 자리 저장
                    ans[j] = i + 1;
                    break;
                }
            }
        }

        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
        br.close();
    }
}
