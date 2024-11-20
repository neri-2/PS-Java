package baekjoon.bronze.ii.n2747;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();

        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 2) + list.get(i - 1));
        }
        System.out.println(list.get(n));
    }
}
