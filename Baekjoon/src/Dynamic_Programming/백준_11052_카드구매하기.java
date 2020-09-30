package Dynamic_Programming;

import java.util.Scanner;

public class 백준_11052_카드구매하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            for(int j=0; j<=(i-1)/2; j++){
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j-1]);
            }
            dp[i] = Math.max(dp[i], arr[i]);
        }
        System.out.println(dp[n-1]);
    }
}
