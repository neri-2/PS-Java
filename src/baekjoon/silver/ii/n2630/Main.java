package baekjoon.silver.ii.n2630;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int whiteResult = 0;
    static int blueResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                String s = st.nextToken();
                paper[i][j] = s.equals("1"); // boolean은 형변환 시 String 값이 "true" 일 시 true 반환
            }
        }

        findPaper(paper, N, 0, 0);
        System.out.println(whiteResult);
        System.out.println(blueResult);
        br.close();
    }

    private static void findPaper(boolean[][] paper, int N, int numX, int numY) {
        boolean check = false;
        boolean thisResult = paper[numX][numY];
        for (int i = numX; i < N + numX; i++) {
            for (int j = numY; j < N + numY; j++) {
                if (paper[i][j] != thisResult) {
                    check = true;
                    break;
                }
                if (check) break;
            }
        }
        if (check) {
            findPaper(paper, N / 2, numX, numY);
            findPaper(paper, N / 2, numX + N / 2, numY);
            findPaper(paper, N / 2, numX, numY + N / 2);
            findPaper(paper, N / 2, numX + N / 2, numY + N / 2);
        } else {
            if (!thisResult) whiteResult++;
            else blueResult++;
        }
    }
}
