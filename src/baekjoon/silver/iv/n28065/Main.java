package baekjoon.silver.iv.n28065;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        int oddCount = 0;
        int evenCount = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = n - oddCount++;
            } else {
                nums[i] = evenCount++;
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
