package baekjoon.silver.iii.n15889;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> range = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            pos.add(Integer.valueOf(st.nextToken()));
        }

        if (N > 1) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N - 1; i++) {
                range.add(Integer.valueOf(st2.nextToken()));
            }
        }

        boolean[] check = new boolean[N];
        check[0] = true;

        // 욱제부터 시작
        for (int i = 0; i < N - 1; i++) {
            if (!check[i]) {
                break;
            }

            Integer curPos = pos.get(i);
            Integer curRange = range.get(i);
            for (int j = i + 1; j < N; j++) {
                Integer target = pos.get(j);
                if (curPos + curRange < target) {
                    break;
                }

                check[j] = true;
            }
        }
        if (check[N - 1]) bw.write("권병장님, 중대장님이 찾으십니다");
        else bw.write("엄마 나 전역 늦어질 것 같아");

        bw.flush();
        br.close();
        bw.close();
    }
}
