package baekjoon.silver.iii.n15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] nums;
    static Deque<Integer> ans;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        ans = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        calc(0);

        br.close();
    }

    private static void calc(int index) {
        // 인덱스가 범위를 넘어서고 사이즈가 맞지 않을 때 해당 X
        if (index >= n && ans.size() != m) return;
        // 사이즈가 같아지면 출력
        else if (ans.size() == m) {
            for (Integer a : ans) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        // 정답 쌓기, 큰 수 넣기 때문에 현재 index + 1 수 백트래킹
        for (int i = index; i < n; i++) {
            ans.addLast(nums[i]);
            calc(i + 1);
            ans.removeLast();
        }
    }
}
