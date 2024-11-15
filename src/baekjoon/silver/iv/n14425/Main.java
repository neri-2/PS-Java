package baekjoon.silver.iv.n14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        set = new HashSet<>();

        for (int i = 0; i < n; i++) set.add(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) count++;
        }
        System.out.println(count);

        br.close();
    }
}
