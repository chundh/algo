package Dynamic_Programming;

import java.util.Scanner;

/**
 * n=1 -> 1 : 1
 * n=2 -> 00 11 : 2
 * n=3 -> 001 100 111 : 3
 * n=4 -> 0000 0011 1100 1001 1111 : 5
 * n=5 -> 00001 10000 00100 11100 00111 10011 11001 11111 : 8
 */

public class baek_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] %= 15746;
            }
        }
        System.out.println(dp[n]);
    }
}
