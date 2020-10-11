package Dynamic_Programming;

import java.util.Scanner;

public class 백준_2225_합분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] dp = new long[201][201];

        for(int i=0; i<=200; i++){
            dp[i][0] = 1;
            dp[1][i] = 1;
        }
        for(int i=1; i<=200; i++){
            dp[2][i] = i+1;
        }
        for(int i=3; i<=200; i++){
            for(int j=1; j<=200; j++){
                for(int l=0; l<=j; l++){
                    dp[i][j] += dp[i-1][j-l]%1000000000;
                }
            }
        }
        System.out.println(dp[k][n]%1000000000);
    }
}
/*
dp[1][2] -> 01 10
dp[2][2] -> 02 11 20
dp[3][2] -> dp[2][1] + dp[1][1] + dp[0][1] + 1
dp[3][3] -> 003 012 021 030 111 210 300 102 201 dp[0][2] *3 +
012 021 102 120 201 210
dp[n][k] = dp[n-1][k-1] + dp[n-2][k-1] ... dp[0][k-1]*k + 1
 */