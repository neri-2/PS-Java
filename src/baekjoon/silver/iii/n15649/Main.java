package baekjoon.silver.iii.n15649;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] flags = new boolean[N + 1];
        int count = 1;

        recursion(N, count, M, bw, flags, q);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void recursion(int N, int count, int M, BufferedWriter bw, boolean[] flags, Deque<Integer> q) throws IOException {
        for (int i = 1; i <= N; i++) {

            if (count > M) {
                for (Integer number : q) {
                    bw.write(number + " ");
                }
                bw.newLine();
                bw.flush();
                break;
            }

            if (flags[i]) continue;

            flags[i] = true;
            q.addLast(i);
            count++;

            recursion(N, count, M, bw, flags, q);
            q.removeLast();
            count--;

            flags[i] = false;
        }
    }
}
