package Dynamic_Programming;

import java.util.Scanner;

public class baek_1890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
                dp[i][j] = 0;
            }
        }
        System.out.println(solution(arr, dp, 0, 0, n));
    }

    public static long solution(int[][] arr, long[][] dp, int i, int j, int n){
        if(i>=n || j>=n)
            return 0;
        if(dp[i][j] != 0)
            return dp[i][j];
        if(i==n-1 && j==n-1){
            return 1;
        }
        if(arr[i][j] == 0)
            return 0;
        int cnt = 0;
        cnt += solution(arr, dp, i+arr[i][j], j, n);
        cnt += solution(arr, dp, i, arr[i][j] + j, n);
        dp[i][j] = cnt;
        return cnt;
    }
}
