package baekjoon.silver.iv.n18110;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        int index = (int) Math.round(n * 0.15);

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());

        for (int i = index; i < n - index; i++) {
            sum += list.get(i);
        }

        bw.write(String.valueOf(Math.round((double) sum / (n - index * 2))));

        bw.flush();
        br.close();
        bw.close();
    }
}
