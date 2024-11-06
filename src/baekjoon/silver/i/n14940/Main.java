package baekjoon.silver.i.n14940;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 방향 설정 -> 일차원 배열로 pair 생성
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        int[] start = new int[0];

        // 지도 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer iterSt = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(iterSt.nextToken());

                if (map[i][j] == 0) answer[i][j] = 0;
                else answer[i][j] = -1;

                if (map[i][j] == 2) {
                    start = new int[]{i, j};
                    answer[i][j] = 0;
                }
            }
        }

        bfs(map, answer, start);

        // 답 출력
        for (int[] ints : answer) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int[][] map, int[][] answer, int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 현재 좌표
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                // 방문 좌표
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                // 지도 범위 벗어나는 경우
                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;
                // 벽이거나 방문한 좌표인 경우
                if (map[nextX][nextY] != 1 || answer[nextX][nextY] != -1) continue;
                // answer = cur answer + 1 & queue offer
                answer[nextX][nextY] = answer[x][y] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }
}
