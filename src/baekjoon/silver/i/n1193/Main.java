package baekjoon.silver.i.n1193;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int X = Integer.parseInt(br.readLine());

        int count = 1;

        while (X > count) X -= count++;

        if (count % 2 == 0) {
            bw.write(X + "/" + (count - X + 1));
        } else {
            bw.write((count - X + 1) + "/" + X);
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
