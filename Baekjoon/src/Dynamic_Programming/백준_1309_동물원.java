package Dynamic_Programming;

import java.util.Scanner;

public class 백준_1309_동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 3;
        if(n>=2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
            }
        }
        System.out.println(dp[n] % 9901);
    }
}
