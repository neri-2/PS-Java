package baekjoon.silver.iii.n13268;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int run = Integer.parseInt(br.readLine()) % 100;

        if (run > 75 && run < 85) {
            bw.write(String.valueOf(4));
            bw.newLine();
        } else if (run > 40 && run < 50 || run > 70 && run < 90) {
            bw.write(String.valueOf(3));
            bw.newLine();
        } else if (run > 15 && run < 25 || run > 35 && run < 55 || run > 65 && run < 95) {
            bw.write(String.valueOf(2));
            bw.newLine();
        } else if (run > 0 && run < 10 || run > 10 && run < 30 || run > 30 && run < 60 || run > 60) {
            bw.write(String.valueOf(1));
            bw.newLine();
        } else {
            bw.write(String.valueOf(0));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
