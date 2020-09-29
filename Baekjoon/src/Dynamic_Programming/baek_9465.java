package Dynamic_Programming;

import java.util.*;

/**
 * dp[i][0] = dp[i-1][1]
 */

public class baek_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test_case = 0; test_case<t; test_case++){
            int m = sc.nextInt();
            int[][] arr = new int[2][m+1];
            for(int i=0; i<2; i++){
                for(int j=1; j<=m; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[2][m+1];
            dp[0][0] = 0;
            dp[1][0] = 0;
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int i=2; i<=m; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }

            System.out.println(Math.max(dp[0][m], dp[1][m]));
        }
    }
}