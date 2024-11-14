package baekjoon.silver.ii.n2915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static String roman;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        roman = br.readLine();
        branch();
        br.close();
    }

    private static void branch() {
        // I 1 V 1 > IV always
        if (roman.contains("VI") && !roman.contains("VII") && !roman.contains("VIII")) {
            roman = roman.replace("VI", "IV");
        }
        // X 1 L 1 > XL always
        if (roman.contains("LX") && !roman.contains("LXX") && !roman.contains("LXXX")) {
            roman = roman.replace("LX", "XL");
        }

        // C > not change
        if (roman.contains("C")) System.out.println(roman);
        // X 1 or more I only 1 not XL not V > IX
        else if (roman.equals("LXXI")) {
            System.out.println("XLIX");
        } else if (roman.contains("X") && !roman.contains("XL") && roman.indexOf("I") == roman.length() - 1 && !roman.contains("V")) {
            int index = roman.indexOf("X");
            StringBuilder sb = new StringBuilder(roman);
            sb.deleteCharAt(index).append("X");
            System.out.println(sb);
        }
        // else not change
        else System.out.println(roman);
    }
}
