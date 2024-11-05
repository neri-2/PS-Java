package baekjoon.silver.iv.n17219;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<String, String> passwords = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            StringTokenizer iterSt = new StringTokenizer(br.readLine(), " ");
            passwords.put(iterSt.nextToken(), iterSt.nextToken());
        }

        for (int i = 0; i < M; i++) {
            bw.write(passwords.get(br.readLine()));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
