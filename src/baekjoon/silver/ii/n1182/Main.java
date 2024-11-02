package baekjoon.silver.ii.n1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st1.nextToken());
        int S = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] ints = new int[N];
        boolean[] checkArr = new boolean[N];
        int count = 0;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(st2.nextToken());
        }

        recursion(N, S, ints, checkArr, count, sum, start);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recursion(int N, int S, int[] ints, boolean[] checkArr, int count, int sum, int start) {
        for (int i = start; i < N; i++) {
            if (count == N) return;
            if (checkArr[i]) continue;
            checkArr[i] = true;
            sum += ints[i]; // 반복문에서 돌아갈 때 계산 중복, 각 반복문마다 다시 빼줘야 함
            if (sum == S) result++;
            recursion(N, S, ints, checkArr, count + 1, sum, i + 1);
            checkArr[i] = false; // 순서도 결과에 들어가버림 -> start 변수 생성해서 본인 다음부터 루프
            sum -= ints[i];
        }
    }
}
