package baekjoon.silver.i.n7562;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 방향 설정
        List<Pair> dirs = new ArrayList<>();
        makeDir(dirs);

        // BFS 큐
        Queue<Pair> queue = new ArrayDeque<>();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            int l = Integer.parseInt(br.readLine());
            int[][] chessMap = new int[l][l];

            // 위치 저장
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            Pair firstLoc = new Pair(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));

            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            Pair des = new Pair(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));

            // 첫 번째
            queue.offer(firstLoc);

            int answer = 0;
            if (!firstLoc.equals(des)) {
                while (!queue.isEmpty()) {
                    Pair poll = queue.poll();

                    for (Pair dir : dirs) {
                        int nextA = poll.a + dir.a;
                        int nextB = poll.b + dir.b;

                        if (nextA < 0 || nextA >= l || nextB < 0 || nextB >= l || chessMap[nextA][nextB] != 0) {
                            continue;
                        }

                        chessMap[nextA][nextB] = chessMap[poll.a][poll.b] + 1;
                        queue.offer(new Pair(nextA, nextB));

                        if (nextA == des.a && nextB == des.b) {
                            answer = chessMap[nextA][nextB];
                            queue.clear();
                            break;
                        }
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }

    public static class Pair {
        int a;
        int b;

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Pair pair = (Pair) object;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    public static void makeDir(List<Pair> list) {
        list.add(new Pair(-1, 2));
        list.add(new Pair(-2, 1));
        list.add(new Pair(-2, -1));
        list.add(new Pair(-1, -2));
        list.add(new Pair(1, 2));
        list.add(new Pair(2, 1));
        list.add(new Pair(2, -1));
        list.add(new Pair(1, -2));
    }
}
