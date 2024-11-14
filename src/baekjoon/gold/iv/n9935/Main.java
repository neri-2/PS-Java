package baekjoon.gold.iv.n9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static BufferedReader br;
    static String str;
    static String bombStr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bombStr = br.readLine();
        start(); // 시간 초과 발생
        if (str.isEmpty()) System.out.println("FRULA");
        else System.out.println(str);
        br.close();
    }

    private static void start() {
        StringBuilder sb = new StringBuilder(str);
        Queue<Integer> queue = new ArrayDeque<>();

        while (sb.indexOf(bombStr) != -1) {
            int index = sb.indexOf(bombStr);
            while (index != -1) {
//            str = str.replace(bombStr, ""); // 계속 새로운 문자열 생성 -> 메모리 초과 -> StringBuilder
                queue.offer(index);
                index = sb.indexOf(bombStr, index + 1);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int popped = queue.poll();
                int length = bombStr.length();
                sb.delete(popped - i * length, popped - i * length + length);
            }
        }

        str = sb.toString();
    }
}
