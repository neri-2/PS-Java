package baekjoon.gold.n7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][][] tomatos;
    static int m;
    static int n;
    static int h;
    static int max;
    static boolean failCheck;

    public static void main(String[] args) throws IOException {
        def();
        input();
        execute();
        check();
        output();
        br.close();
    }

    private static void def() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomatos = new int[h][n][m];
    }

    private static void input() throws IOException {
        for (int i = 0; i < h; i++)
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++)
                    tomatos[i][j][k] = Integer.parseInt(st.nextToken());
            }
    }

    private static void execute() {
        int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        // 1인 것 들 다 큐에 집어넣기
        for (int i = 0; i < h; i++)
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++)
                    if (tomatos[i][j][k] == 1)
                        queue.offer(new int[]{i, j, k});
            }
        // 빼서 방향 있는 것들 자기의 +1 해서 큐에 넣기
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nextH = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                int nextM = cur[2] + dir[2];

                if (nextH < 0 || nextH >= h || nextN < 0 || nextN >= n || nextM < 0 || nextM >= m || tomatos[nextH][nextN][nextM] != 0)
                    continue;

                tomatos[nextH][nextN][nextM] = tomatos[cur[0]][cur[1]][cur[2]] + 1;
                queue.offer(new int[]{nextH, nextN, nextM});

            }
        }
    }

    private static void check() {
        for (int[][] tomato : tomatos)
            for (int[] ints : tomato)
                for (int i : ints)
                    if (i == 0) {
                        failCheck = true;
                        return;
                    } else if (max < i) max = i;
    }

    private static void output() {
        if (failCheck) System.out.println(-1);
        else System.out.println(max - 1);
    }
}
