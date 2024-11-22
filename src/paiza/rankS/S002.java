package paiza.rankS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S002 {

    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] startDir;
    static int[] goalDir;
    static char[][] map;
    static int[][] bfs;
    static Queue<int[]> q;
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        bfs = new int[n][m];
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 's') startDir = new int[]{i, j};
                if (map[i][j] == 'g') goalDir = new int[]{i, j};
            }
        }

        q.add(new int[]{startDir[0], startDir[1]});
        bfs[startDir[0]][startDir[1]] = 1;
        bfs();
        if (bfs[goalDir[0]][goalDir[1]] == 0) System.out.println("Fail");
        else System.out.println(bfs[goalDir[0]][goalDir[1]] - 1);

        br.close();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curN = cur[0];
            int curM = cur[1];
            if (curN == goalDir[0] && curM == goalDir[1]) return;

            for (int[] dir : dirs) {
                int newN = curN + dir[0];
                int newM = curM + dir[1];
                if (newN < 0 || newN >= n || newM < 0 || newM >= m) continue;
                if (map[newN][newM] == '1' || bfs[newN][newM] != 0) continue;
                bfs[newN][newM] = bfs[curN][curM] + 1;
                q.add(new int[]{newN, newM});
            }
        }
    }
}
